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
import java.util.List;

public class GoToAgentPage implements Command {
    private final Logger LOGGER = Logger.getLogger(GoToAgentPage.class);

    private final String PATH_TO_AGENT_PAGE = "WEB-INF/jsp/agent/agentPage.jsp";
    private final String AGENTS = "agents";
    private final String ERROR_ATTRIBUTE = "errorMsg";
    private final String SERVER_ERROR= "Sorry, server error.";
    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<AgentEntity> agents = (List<AgentEntity>) session.getAttribute(AGENTS);

        if(agents == null){

            ServiceProvider provider = ServiceProvider.getInstance();
            AgentService agentService = provider.getAgentService();

            try{
                agents = agentService.getAllAgents();

                session.setAttribute(AGENTS, agents);

            } catch (ServiceException e) {
                LOGGER.error(SERVER_ERROR, e);

                request.setAttribute(ERROR_ATTRIBUTE, SERVER_ERROR);
                RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_ERROR_PAGE);
                dispatcher.forward(request, response);
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_AGENT_PAGE);
        dispatcher.forward(request, response);
    }
}
