package com.ccm.mapper;

import com.ccm.bean.OrdersInfo;
import com.ccm.utils.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface OrdersInfoMapper extends IBaseMapper<OrdersInfo> {

    void updateReturnOrders(@Param("id") Long id);

    void updateOrders(@Param("id") Long id);
}