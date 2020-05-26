package com.ccm.controller;

import com.ccm.bean.ComputersDetail;
import com.ccm.common.CodeConstant;
import com.ccm.common.MessageConstant;
import com.ccm.common.PageResponseBean;
import com.ccm.service.ComputerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ComputersController {
    private final static Logger logger = LoggerFactory.getLogger(ComputersController.class);

    @Resource
    private ComputerService computerService;

    @ResponseBody
    @GetMapping("/select/all")
    public PageResponseBean<List<ComputersDetail>> selectall(){
        PageResponseBean<List<ComputersDetail>> result = new PageResponseBean<>();
        List<ComputersDetail> computersDetails = computerService.selectAllComputer();
        if (CollectionUtils.isEmpty(computersDetails)){
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.RECEIVE_SUCCESS);
        result.setData(computersDetails);
        logger.info("ComputersController: selectall ----> 查询所有电脑货品！");
        return result;
    }
}
