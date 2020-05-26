package com.ccm.controller;

import com.ccm.dto.DetailInfoDTO;
import com.ccm.bean.ComputersDetail;
import com.ccm.bean.SwiperInfo;
import com.ccm.common.CodeConstant;
import com.ccm.common.MessageConstant;
import com.ccm.common.ResponseBean;
import com.ccm.service.ComputerService;
import com.ccm.service.SwiperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class SwiperController {
    private final static Logger logger = LoggerFactory.getLogger(SwiperController.class);

    @Resource
    private SwiperService swiperService;
    @Resource
    private ComputerService computerService;

    @ResponseBody
    @GetMapping("/select/by/{id}")
    public ResponseBean<DetailInfoDTO> selectById(@PathVariable(value = "id") Long id){
        ResponseBean<DetailInfoDTO> result = new ResponseBean<>();
        if(id == null) {
            result.setMessage(MessageConstant.FAILURE);
            result.setStatus(CodeConstant.ERROR);
            return result;
        }
        SwiperInfo swiperInfo = swiperService.selectByid(id);
        ComputersDetail computersDetail = computerService.selectById(id);
        DetailInfoDTO detailInfoDTO = swiperService.alterDetailInfo(computersDetail, swiperInfo);
        if (detailInfoDTO == null) {
            result.setMessage(MessageConstant.FAILURE);
            result.setStatus(CodeConstant.ERROR);
            return result;
        }
        result.setMessage(MessageConstant.RECEIVE_SUCCESS);
        result.setStatus(CodeConstant.SUCCESS);
        result.setData(detailInfoDTO);
        logger.info("SwiperController: selectById ----> 获取商品id为："+id+"的详细信息");
        return result;
    }

}
