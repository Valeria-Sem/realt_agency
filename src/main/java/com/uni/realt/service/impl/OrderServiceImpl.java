package com.uni.realt.service.impl;

import com.uni.realt.dao.DAOException;
import com.uni.realt.dao.DAOProvider;
import com.uni.realt.dao.OrderDAO;
import com.uni.realt.entity.OrderEntity;
import com.uni.realt.service.OrderService;
import com.uni.realt.service.ServiceException;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public void save(OrderEntity order) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        OrderDAO orderDAO = provider.getOrderDAO();

        try{
            orderDAO.save(order);

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<OrderEntity> getAllOrders() throws ServiceException {
        List<OrderEntity> orders;

        DAOProvider provider = DAOProvider.getInstance();
        OrderDAO orderDAO = provider.getOrderDAO();

        try{
            orders = orderDAO.getAllOrders();

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }

        return orders;
    }

    @Override
    public OrderEntity getOrderById(long id) throws ServiceException {
        OrderEntity order;

        DAOProvider provider = DAOProvider.getInstance();
        OrderDAO orderDAO = provider.getOrderDAO();

        try{
            order = orderDAO.getOrderById(id);

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }

        return order;
    }

    @Override
    public void updateOrder(OrderEntity order) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        OrderDAO orderDAO = provider.getOrderDAO();

        try{
            orderDAO.updateOrder(order);

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void delete(long id) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        OrderDAO orderDAO = provider.getOrderDAO();

        try{
            orderDAO.delete(id);

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<OrderEntity> search(String part) throws ServiceException {
        List<OrderEntity> orders;

        DAOProvider provider = DAOProvider.getInstance();
        OrderDAO orderDAO = provider.getOrderDAO();

        try{
            orders = orderDAO.search(part);

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }

        return orders;
    }

    @Override
    public List<OrderEntity> sort(String sort) throws ServiceException {
        List<OrderEntity> orders;

        DAOProvider provider = DAOProvider.getInstance();
        OrderDAO orderDAO = provider.getOrderDAO();

        try{
            orders = orderDAO.sort(sort);

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }

        return orders;
    }
}
