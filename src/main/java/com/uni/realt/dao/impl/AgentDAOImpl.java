package com.uni.realt.dao.impl;

import com.uni.realt.dao.AgentDAO;
import com.uni.realt.dao.DAOException;
import com.uni.realt.dao.pool.ConnectionPool;
import com.uni.realt.dao.pool.ConnectionPoolException;
import com.uni.realt.entity.AgentEntity;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgentDAOImpl implements AgentDAO {
    private final Logger LOGGER = Logger.getLogger(AgentDAOImpl.class);

    private final String GET_ALL_QUERY = "select * from agent";
    private final String GET_BY_ID_QUERY = "select * from agent where id = ";
    private final String INSERT_QUERY = "insert into agent (fio) values(?) ";
    private final String DELETE_QUERY = "delete from agent where id = ";
    private final String UPDATE_QUERY ="UPDATE agent SET fio = ? WHERE id = ?";

    private final String ID ="id";
    private final String FIO ="fio";

    @Override
    public void save(AgentEntity agent) throws DAOException {
        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement statement = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();

            statement = connection.prepareStatement(INSERT_QUERY);

            statement.setString(1, agent.getFio());

            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error("Some problems with saving new agent: " + e.getLocalizedMessage());
            throw new DAOException(e.getLocalizedMessage(), e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }
    }

    @Override
    public List<AgentEntity> getAllAgents() throws DAOException {
        List<AgentEntity> agents = new ArrayList<>();

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
                AgentEntity agent = new AgentEntity();
                agent.setId(Long.parseLong(res.getString(ID)));
                agent.setFio(res.getString(FIO));

                agents.add(agent);
            }
        } catch (ConnectionPoolException | SQLException e){
            LOGGER.error("Some problems with extracting agents: " + e.getLocalizedMessage());
            throw new DAOException(e.getLocalizedMessage(), e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps, res);
            }
        }

        return agents;
    }

    @Override
    public AgentEntity getAgentById(long id) throws DAOException {
        AgentEntity agent = null;
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
                long agentId = res.getLong(ID);
                String agentFio = res.getString(FIO);

                agent = new AgentEntity(agentId, agentFio);
            }

        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error("Some problems with extracting agent: " + e.getLocalizedMessage());
            throw new DAOException(e.getLocalizedMessage(), e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement, res);
            }
        }

        return agent;
    }

    @Override
    public void updateAgent(AgentEntity agent) throws DAOException {
        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement statement = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();

            statement = connection.prepareStatement(UPDATE_QUERY);

            statement.setString(1, agent.getFio());
            statement.setLong(2, agent.getId());

            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error("Some problems with updating agent: " + e.getLocalizedMessage());
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
            LOGGER.error("Some problems with deleting agent: " + e.getLocalizedMessage());
            throw new DAOException(e.getLocalizedMessage(), e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }
    }
}
