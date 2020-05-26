package com.ccm.service;

import com.ccm.bean.ComputersDetail;
import com.ccm.bean.OrdersInfo;
import com.ccm.bean.SwiperInfo;
import com.ccm.dto.OrdersDTO;
import com.ccm.mapper.OrdersInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class OrdersService {

    private final static Logger logger = LoggerFactory.getLogger(OrdersService.class);

    @Resource
    private OrdersInfoMapper orderMapper;

    @Resource
    private ComputerService computerService;

    /**
     * 添加订单
     */
    public void insertOrder(OrdersInfo orders) {
        if (orders == null) {
            logger.info("添加订单失败！");
            return;
        }
        orderMapper.insert(orders);
    }

    /**
     * 查询所有订单信息
     */
    public List<OrdersInfo> findAllOrders() {
        List<OrdersInfo> list = orderMapper.selectAll();
        if (CollectionUtils.isEmpty(list)){
            logger.info("未查询到有订单！");
            return null;
        }
        return list;
    }

    /**
     * 通过swiper详细封装订单
     */
    public OrdersInfo changeSwiper(SwiperInfo swiperInfo) {
        OrdersInfo ordersInfo = new OrdersInfo();
        ordersInfo.setImageUrl(swiperInfo.getFirUrl());
        ComputersDetail computersDetail = computerService.selectById(swiperInfo.getComputerId());
        ordersInfo.setPrice(computersDetail.getPrice());
        ordersInfo.setGoodDetail(computersDetail.getGoodsDescribe());
        return ordersInfo;
    }

    /**
     * 通过status=0来查询所有未支付的订单
     */
    public List<OrdersDTO> selectByStatus() {
        Example example = new Example(OrdersInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", "0");
        List<OrdersInfo> list = orderMapper.selectByExample(example);

        List<OrdersDTO> ordersDTOList = new ArrayList<>();
        OrdersInfo ordersInfo;
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            ordersInfo = (OrdersInfo)iterator.next();
            ordersDTOList.add(changeOrders(ordersInfo));
        }
        if (CollectionUtils.isEmpty(list)){
            return null;
        }
        return ordersDTOList;
    }

    /**
     * 通过status=1来查询所有代发货的订单
     */
    public List<OrdersDTO> selectNoSent() {
        Example example = new Example(OrdersInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", "1");
        List<OrdersInfo> list = orderMapper.selectByExample(example);
        List<OrdersDTO> ordersDTOList = new ArrayList<>();
        OrdersInfo ordersInfo;
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            ordersInfo = (OrdersInfo)iterator.next();
            ordersDTOList.add(changeOrders(ordersInfo));
        }
        if (CollectionUtils.isEmpty(list)){
            return null;
        }
        return ordersDTOList;
    }

    /**
     * 顾客直接购买详情页面中的商品
     */
    public void insById(Long id) {
        if (id == null) {
            return;
        }
        ComputersDetail computer = computerService.selectById(id);
        OrdersInfo info = new OrdersInfo();
        info.setGoodDetail(computer.getGoodsDescribe());
        info.setPrice(computer.getPrice());
        info.setImageUrl(computer.getImageUrl());
        info.setStatus("1");
        orderMapper.insert(info);
    }

    /**
     * 封装OrdersInfo成OrdersDTO
     */
    public OrdersDTO changeOrders(OrdersInfo ordersInfo) {
        OrdersDTO ordersDTO = new OrdersDTO();
        if (ordersInfo.getIsCheck() == '0'){
            ordersDTO.setCheck(true);
        } else {
            ordersDTO.setCheck(false);
        }
        ordersDTO.setCreateTime(ordersInfo.getCreateTime());
        ordersDTO.setGoodDetail(ordersInfo.getGoodDetail());
        ordersDTO.setId(ordersInfo.getId());
        ordersDTO.setImageUrl(ordersInfo.getImageUrl());
        ordersDTO.setModifyTime(ordersInfo.getModifyTime());
        ordersDTO.setPrice(ordersInfo.getPrice());
        ordersDTO.setStatus(ordersInfo.getStatus());
        return ordersDTO;
    }

    /**
     * 已支付订单, 即改变订单的状态为1
     */
    public void updateOrders(Long id) {
        if (id == null) {
            return;
        }
        orderMapper.updateOrders(id);
    }

    /**
     * 退货操作，根据传入id将对应订单的status改为2
     */
    public void updateReturnOrders(Long id) {
        if (id == null) {
            return;
        }
        orderMapper.updateReturnOrders(id);
    }
}
