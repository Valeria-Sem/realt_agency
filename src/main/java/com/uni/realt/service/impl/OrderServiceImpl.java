package com.uni.realt.service.impl;

import com.uni.realt.entity.OrderEntity;
import com.uni.realt.service.OrderService;
import com.uni.realt.service.ServiceException;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public void save(OrderEntity order) throws ServiceException {

    }

    @Override
    public List<OrderEntity> getAllOrders() throws ServiceException {
        return null;
    }

    @Override
    public OrderEntity getOrderById(long id) throws ServiceException {
        return null;
    }

    @Override
    public void updateOrder(OrderEntity order) throws ServiceException {

    }

    @Override
    public void delete(long id) throws ServiceException {

    }
}
