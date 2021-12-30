package com.uni.realt.controller.command.impl.page;

import com.uni.realt.controller.command.Command;
import com.uni.realt.entity.AgentEntity;
import com.uni.realt.service.AgentService;
import com.uni.realt.service.ServiceException;
import com.uni.realt.service.ServiceProvider;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoToUpdateAgentPage implements Command {
    private final Logger LOGGER = Logger.getLogger(GoToAgentPage.class);

    private final String PATH_TO_UPDATE_AGENT_PAGE = "WEB-INF/jsp/agent/updatePage.jsp";
    private final String AGENT = "agent";
    private final String ID = "id";
    private final String ERROR_ATTRIBUTE = "errorMsg";
    private final String SERVER_ERROR= "Sorry, server error.";
    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServiceProvider provider = ServiceProvider.getInstance();
        AgentService agentService = provider.getAgentService();

        long id = Long.parseLong(request.getParameter(ID));

        try{
            AgentEntity agent = agentService.getAgentById(id);

            session.setAttribute(AGENT, agent);
            session.setAttribute(ID, id);

            RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_UPDATE_AGENT_PAGE);
            dispatcher.forward(request, response);
        } catch (ServiceException e) {
            LOGGER.error(SERVER_ERROR, e);

            request.setAttribute(ERROR_ATTRIBUTE, SERVER_ERROR);
            RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_ERROR_PAGE);
            dispatcher.forward(request, response);
        }
    }
}
