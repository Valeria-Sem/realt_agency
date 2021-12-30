package com.uni.realt.controller.command.impl.create;

import com.uni.realt.controller.command.Command;
import com.uni.realt.controller.command.impl.update.UpdateOrder;
import com.uni.realt.entity.OrderEntity;
import com.uni.realt.service.OrderService;
import com.uni.realt.service.ServiceException;
import com.uni.realt.service.ServiceProvider;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreateNewOrder implements Command {
    private final Logger LOGGER = Logger.getLogger(UpdateOrder.class);

    private final String GO_TO_HOME_PAGE_COMMAND = "controller?command=gotohomepage";
    private final String ORDERS = "orders";
    private final String CLIENT = "client";
    private final String OPERATION = "operation";
    private final String AGENT = "agent";
    private final String ERROR_ATTRIBUTE = "errorMsg";
    private final String SERVER_ERROR= "Sorry, server error.";
    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String client = request.getParameter(CLIENT);
        String operation = request.getParameter(OPERATION);
        String agent = request.getParameter(AGENT);

        OrderEntity orderEntity;

        try{
            ServiceProvider provider = ServiceProvider.getInstance();
            OrderService orderService = provider.getOrderService();

            orderEntity = new OrderEntity(client, operation, agent);
            orderService.save(orderEntity);

            session.removeAttribute(ORDERS);

            response.sendRedirect(GO_TO_HOME_PAGE_COMMAND);

        } catch (ServiceException e) {
            LOGGER.error(SERVER_ERROR, e);

            request.setAttribute(ERROR_ATTRIBUTE, SERVER_ERROR);
            RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_ERROR_PAGE);
            dispatcher.forward(request, response);
        }
    }
}
