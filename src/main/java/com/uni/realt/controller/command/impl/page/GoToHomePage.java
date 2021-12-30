package com.uni.realt.controller.command.impl.page;

import com.uni.realt.controller.command.Command;
import com.uni.realt.entity.AgentEntity;
import com.uni.realt.entity.ClientEntity;
import com.uni.realt.entity.OperationEntity;
import com.uni.realt.entity.OrderEntity;
import com.uni.realt.service.*;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GoToHomePage implements Command {
    private final Logger LOGGER = Logger.getLogger(GoToHomePage.class);

    private final String PATH_TO_MAIN_PAGE = "WEB-INF/jsp/home/homePage.jsp";
    private final String ORDERS = "orders";
    private final String AGENTS = "agents";
    private final String CLIENTS = "clients";
    private final String OPERATIONS = "operations";
    private final String ERROR_ATTRIBUTE = "errorMsg";
    private final String SERVER_ERROR= "Sorry, server error.";
    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";

    public GoToHomePage() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<OrderEntity> orders = (List<OrderEntity>) session.getAttribute(ORDERS);
        List<AgentEntity> agents = (List<AgentEntity>) session.getAttribute(ORDERS);
        List<ClientEntity> clients = (List<ClientEntity>) session.getAttribute(ORDERS);
        List<OperationEntity> operations = (List<OperationEntity>) session.getAttribute(ORDERS);

        ServiceProvider provider = ServiceProvider.getInstance();
        OrderService orderService = provider.getOrderService();
        AgentService agentService = provider.getAgentService();
        ClientService clientService = provider.getClientService();
        OperationService operationService = provider.getOperationService();

        try {
            if (orders == null) {
                orders = orderService.getAllOrders();
                session.setAttribute(ORDERS, orders);
            }

            if (agents == null) {
                agents = agentService.getAllAgents();
                session.setAttribute(AGENTS, agents);
            }

            if (clients == null) {
                clients = clientService.getAllClients();
                session.setAttribute(CLIENTS, clients);
            }

            if (operations == null) {
                operations = operationService.getAllOperations();
                session.setAttribute(OPERATIONS, operations);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_MAIN_PAGE);
            dispatcher.forward(request, response);

        } catch (ServiceException e) {
            LOGGER.error(SERVER_ERROR, e);

            request.setAttribute(ERROR_ATTRIBUTE, SERVER_ERROR);
            RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_ERROR_PAGE);
            dispatcher.forward(request, response);
        }

    }
}
