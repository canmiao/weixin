package com.ccm.service;

import com.ccm.dto.DetailInfoDTO;
import com.ccm.bean.ComputersDetail;
import com.ccm.bean.SwiperInfo;
import com.ccm.mapper.SwiperInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SwiperService {
    @Resource
    private SwiperInfoMapper swiperMapper;

    /**
     * 根据orderId获取swiper表中的相关信息
     */
    public SwiperInfo selectByid(Long id) {
        if (id == null){
            return null;
        }
        Example example = new Example(SwiperInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("computerId", id);
        List<SwiperInfo> list = swiperMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    /**
     * 封装详情页面中的信息
     */
    public DetailInfoDTO alterDetailInfo(ComputersDetail computer, SwiperInfo swiper){
        DetailInfoDTO detailInfoDTO = new DetailInfoDTO();
        detailInfoDTO.setOrderId(computer.getOrderId());
        detailInfoDTO.setGoodsDescribe(computer.getGoodsDescribe());
        detailInfoDTO.setPrice(computer.getPrice());
        detailInfoDTO.setCreateTime(computer.getCreateTime());
        detailInfoDTO.setDate(computer.getDate());
        detailInfoDTO.setImageUrl(computer.getImageUrl());
        detailInfoDTO.setModifyTime(computer.getModifyTime());
        detailInfoDTO.setStatus(computer.getStatus());
        detailInfoDTO.setFirUrl(swiper.getFirUrl());
        detailInfoDTO.setSecUrl(swiper.getSecUrl());
        detailInfoDTO.setThirdUrl(swiper.getThirdUrl());
        return detailInfoDTO;
    }
}
