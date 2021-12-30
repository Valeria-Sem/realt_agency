package com.uni.realt.service.impl;

import com.uni.realt.dao.AgentDAO;
import com.uni.realt.dao.ClientDAO;
import com.uni.realt.dao.DAOException;
import com.uni.realt.dao.DAOProvider;
import com.uni.realt.entity.AgentEntity;
import com.uni.realt.entity.ClientEntity;
import com.uni.realt.service.AgentService;
import com.uni.realt.service.ServiceException;

import java.util.List;

public class AgentServiceImpl implements AgentService {

    @Override
    public void save(AgentEntity agent) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        AgentDAO agentDAO = provider.getAgentDAO();

        try{
            agentDAO.save(agent);

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<AgentEntity> getAllAgents() throws ServiceException {
        List<AgentEntity> agents;

        DAOProvider provider = DAOProvider.getInstance();
        AgentDAO agentDAO = provider.getAgentDAO();

        try{
            agents = agentDAO.getAllAgents();

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }

        return agents;
    }

    @Override
    public AgentEntity getAgentById(long id) throws ServiceException {
        AgentEntity agent;

        DAOProvider provider = DAOProvider.getInstance();
        AgentDAO agentDAO = provider.getAgentDAO();

        try{
            agent = agentDAO.getAgentById(id);

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }

        return agent;
    }

    @Override
    public void updateAgent(AgentEntity agent) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        AgentDAO agentDAO = provider.getAgentDAO();

        try{
            agentDAO.updateAgent(agent);

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void delete(long id) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        AgentDAO agentDAO = provider.getAgentDAO();

        try{
            agentDAO.delete(id);

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }
    }
}
