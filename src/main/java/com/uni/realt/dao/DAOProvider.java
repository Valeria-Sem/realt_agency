package com.uni.realt.dao;

import com.uni.realt.dao.impl.AgentDAOImpl;
import com.uni.realt.dao.impl.ClientDAOImpl;
import com.uni.realt.dao.impl.OperationDAOImpl;
import com.uni.realt.dao.impl.OrderDAOImpl;

public class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();

    private final AgentDAO agentDAO = new AgentDAOImpl();
    private final ClientDAO clientDAO = new ClientDAOImpl();
    private final OperationDAO operationDAO = new OperationDAOImpl();
    private final OrderDAO orderDAO = new OrderDAOImpl();


    private DAOProvider(){}

    public static DAOProvider getInstance(){
        return instance;
    }

    public AgentDAO getAgentDAO() {
        return agentDAO;
    }

    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    public OperationDAO getOperationDAO() {
        return operationDAO;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }
}
