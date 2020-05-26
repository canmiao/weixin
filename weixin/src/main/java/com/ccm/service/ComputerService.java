package com.ccm.service;

import com.ccm.bean.ComputersDetail;
import com.ccm.mapper.ComputersDetailMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ComputerService {
    @Resource
    ComputersDetailMapper computersMapper;

    /**
     * 查询所有电脑货品
     */
    public List<ComputersDetail> selectAllComputer() {
        List<ComputersDetail> computers = computersMapper.selectAll();
        if (CollectionUtils.isEmpty(computers)){
            return null;
        }
        return computers;
    }

    /**
     * 通过主键来查询信息
     */
    public ComputersDetail selectById(Long id) {
        if (id == null){
            return null;
        }
        return computersMapper.selectByPrimaryKey(id);
    }
}
