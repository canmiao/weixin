package com.ccm.controller;

import com.ccm.bean.OrdersInfo;
import com.ccm.bean.SwiperInfo;
import com.ccm.common.CodeConstant;
import com.ccm.common.MessageConstant;
import com.ccm.common.PageResponseBean;
import com.ccm.common.ResponseBean;
import com.ccm.dto.OrdersDTO;
import com.ccm.service.OrdersService;
import com.ccm.service.SwiperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderController {
    private final static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrdersService ordersService;

    @Resource
    private SwiperService swiperService;

    /**
     * 查询所有订单
     * @return
     */
    @GetMapping("/order/select")
    public PageResponseBean<List<OrdersInfo>> selectAllOrder() {
        PageResponseBean<List<OrdersInfo>> result = new PageResponseBean<>();
        List<OrdersInfo> list = ordersService.findAllOrders();
        if (CollectionUtils.isEmpty(list)){
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        result.setMessage(MessageConstant.RECEIVE_SUCCESS);
        result.setStatus(CodeConstant.SUCCESS);
        result.setData(list);
        logger.info("OrderController: selectAllOrder ----> 查询所有订单！");
        return result;
    }

    /**
     *顾客直接购买详情页面对应订单
     */
    @PostMapping("/order/ins/{id}")
    public  ResponseBean insById(@PathVariable(value = "id") Long id){
        ResponseBean result = new ResponseBean<>();
        if (id == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        ordersService.insById(id);
        result.setMessage(MessageConstant.INSERT_SUCCESS);
        result.setStatus(CodeConstant.SUCCESS);
        return result;
    }



    /**
     * 增加购物车订单
     */
    @GetMapping("/order/insert/{id}")
    public ResponseBean insertById(@PathVariable(value = "id") Long id){
        ResponseBean result = new ResponseBean<>();
        if (id == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        SwiperInfo swiperInfo = swiperService.selectByid(id);
        if (swiperInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        OrdersInfo ordersInfo = ordersService.changeSwiper(swiperInfo);
        ordersService.insertOrder(ordersInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.INSERT_SUCCESS);
        logger.info("OrderController: insertById ----> 添加订单到数据库！");
        return result;
    }

    /**
     * 查询购物车的订单
     */
    @GetMapping("/order/no/pay")
    public PageResponseBean<List<OrdersDTO>> selectOrdersByStatus() {
        PageResponseBean<List<OrdersDTO>> result = new PageResponseBean<>();
        List<OrdersDTO> list = ordersService.selectByStatus();
        if (CollectionUtils.isEmpty(list)){
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        result.setMessage(MessageConstant.RECEIVE_SUCCESS);
        result.setStatus(CodeConstant.SUCCESS);
        result.setData(list);
        logger.info("OrderController: selectOrdersByStatus ----> 查询购物车的订单！");
        return result;
    }

    /**
     * 查询已收货的订单
     */
    @GetMapping("/order/no/sent")
    public PageResponseBean<List<OrdersDTO>> selectOrdersNoSent() {
        PageResponseBean<List<OrdersDTO>> result = new PageResponseBean<>();
        List<OrdersDTO> list = ordersService.selectNoSent();
        if (CollectionUtils.isEmpty(list)){
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        result.setMessage(MessageConstant.RECEIVE_SUCCESS);
        result.setStatus(CodeConstant.SUCCESS);
        result.setData(list);
        logger.info("OrderController: selectOrdersNoSent ----> 查询已收货货的订单！");
        return result;
    }

    /**
     * 已支付订单, 改变订单的状态为1
     */
    @PostMapping("/order/update")
    public ResponseBean deleteOrders(Long id){
        ResponseBean result = new ResponseBean();
        if (id == null){
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        ordersService.updateOrders(id);
        result.setMessage(MessageConstant.SUCCESS);
        result.setStatus(CodeConstant.SUCCESS);
        logger.info("OrderController: selectOrdersNoSent ----> 订单id为："+id+"的订单完成支付！");
        return result;
    }

    /**
     * 商品退货, 改变订单的状态为2
     */
    @PostMapping("/order/return")
    public ResponseBean returnOrders(Long id){
        ResponseBean result = new ResponseBean();
        if (id == null){
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        ordersService.updateReturnOrders(id);
        result.setMessage(MessageConstant.SUCCESS);
        result.setStatus(CodeConstant.SUCCESS);
        logger.info("OrderController: returnOrders ----> 订单id为："+id+"的订单完成退货！");
        return result;
    }
}
