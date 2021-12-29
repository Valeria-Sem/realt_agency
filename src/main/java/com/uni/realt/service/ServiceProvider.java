package com.uni.realt.service;

import com.uni.realt.service.impl.AgentServiceImpl;
import com.uni.realt.service.impl.ClientServiceImpl;
import com.uni.realt.service.impl.OperationServiceImpl;
import com.uni.realt.service.impl.OrderServiceImpl;

public class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    private final AgentService agentService = new AgentServiceImpl();
    private final ClientService clientService = new ClientServiceImpl();
    private final OperationService operationService = new OperationServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

    private ServiceProvider() {}

    public static ServiceProvider getInstance() {
        return instance;
    }

    public AgentService getAgentService() {
        return agentService;
    }

    public ClientService getClientService() {
        return clientService;
    }

    public OperationService getOperationService() {
        return operationService;
    }

    public OrderService getOrderService() {
        return orderService;
    }
}
