package com.uni.realt.dao;

import com.uni.realt.entity.OrderEntity;

import java.util.List;

public interface OrderDAO {
    void save(OrderEntity order) throws DAOException;

    List<OrderEntity> getAllOrders() throws DAOException;

    OrderEntity getOrderById(long id) throws DAOException;

    void updateOrder(OrderEntity order) throws DAOException;

    void delete(long id) throws DAOException;
}
