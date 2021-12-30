package com.uni.realt.service;

import com.uni.realt.dao.DAOException;
import com.uni.realt.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    void save(OrderEntity order) throws ServiceException;

    List<OrderEntity> getAllOrders() throws ServiceException;

    OrderEntity getOrderById(long id) throws ServiceException;

    void updateOrder(OrderEntity order) throws ServiceException;

    void delete(long id) throws ServiceException;

    List<OrderEntity> search(String part) throws ServiceException;

    List<OrderEntity> sort(String sort) throws ServiceException;

}
