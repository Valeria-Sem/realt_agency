package com.uni.realt.dao.impl;

import com.uni.realt.dao.DAOException;
import com.uni.realt.dao.OrderDAO;
import com.uni.realt.dao.pool.ConnectionPool;
import com.uni.realt.dao.pool.ConnectionPoolException;
import com.uni.realt.entity.AgentEntity;
import com.uni.realt.entity.OrderEntity;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private final Logger LOGGER = Logger.getLogger(OrderDAOImpl.class);

    private final String GET_ALL_QUERY = "select * from order";
    private final String GET_BY_ID_QUERY = "select * from order where id = ";
    private final String INSERT_QUERY = "insert into order (client_id, operation_id, agent_id) values(?, ?, ?) ";
    private final String DELETE_QUERY = "delete from order where id = ";
    private final String UPDATE_QUERY ="UPDATE order SET client_id = ?, operation_id = ?, agent_id = ? WHERE id = ?";

    private final String ID ="id";
    private final String CLIENT_ID ="client_id";
    private final String OPERATION_ID ="operation_id";
    private final String AGENT_ID ="agent_id";

    @Override
    public void save(OrderEntity order) throws DAOException {
        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement statement = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();

            statement = connection.prepareStatement(INSERT_QUERY);

            statement.setLong(1, order.getClientId());
            statement.setLong(2, order.getOperationId());
            statement.setLong(3, order.getAgentId());

            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error("Some problems with saving new order: " + e.getLocalizedMessage());
            throw new DAOException(e.getLocalizedMessage(), e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }
    }

    @Override
    public List<OrderEntity> getAllOrders() throws DAOException {
        List<OrderEntity> orders = new ArrayList<>();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(GET_ALL_QUERY);
            res = ps.executeQuery();

            while (res.next()){
                OrderEntity order = new OrderEntity();
                order.setId(Long.parseLong(res.getString(ID)));
                order.setClientId(Long.parseLong(res.getString(CLIENT_ID)));
                order.setOperationId(Long.parseLong(res.getString(OPERATION_ID)));
                order.setAgentId(Long.parseLong(res.getString(AGENT_ID)));

                orders.add(order);
            }
        } catch (ConnectionPoolException | SQLException e){
            LOGGER.error("Some problems with extracting orders: " + e.getLocalizedMessage());
            throw new DAOException(e.getLocalizedMessage(), e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps, res);
            }
        }

        return orders;
    }

    @Override
    public OrderEntity getOrderById(long id) throws DAOException {
        OrderEntity order = null;
        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement statement = null;
        ResultSet res = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();

            statement = connection.prepareStatement(GET_BY_ID_QUERY + id);
            res = statement.executeQuery();

            if (res.next()){
                long orderId = res.getLong(ID);
                long clientId = res.getLong(CLIENT_ID);
                long operationId = res.getLong(OPERATION_ID);
                long agentId = res.getLong(AGENT_ID);

                order = new OrderEntity(orderId, clientId, operationId, agentId);
            }

        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error("Some problems with extracting order: " + e.getLocalizedMessage());
            throw new DAOException(e.getLocalizedMessage(), e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement, res);
            }
        }

        return order;
    }

    @Override
    public void updateOrder(OrderEntity order) throws DAOException {
        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement statement = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();

            statement = connection.prepareStatement(UPDATE_QUERY);

            statement.setLong(1, order.getClientId());
            statement.setLong(2, order.getOperationId());
            statement.setLong(3, order.getAgentId());
            statement.setLong(4, order.getId());

            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error("Some problems with updating order: " + e.getLocalizedMessage());
            throw new DAOException(e.getLocalizedMessage(), e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }
    }

    @Override
    public void delete(long id) throws DAOException {
        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement statement = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            statement = connection.prepareStatement(DELETE_QUERY + id);
            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error("Some problems with deleting order: " + e.getLocalizedMessage());
            throw new DAOException(e.getLocalizedMessage(), e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }
    }
}
