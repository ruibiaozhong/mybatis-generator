package com.leihou.so.service.impl;

import com.leihou.so.mapper.OrderMapper;
import com.leihou.so.entity.Order;
import com.leihou.so.service.OrderService;
import com.leihou.so.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * Created by ruibiaozhong on 2018/10/26.
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

}
