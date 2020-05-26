package com.ccm.utils.base;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: ccm
 * @Description: 通用的mapper
 * @Date: 10:07 2018/8/8
 */
public interface IBaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}