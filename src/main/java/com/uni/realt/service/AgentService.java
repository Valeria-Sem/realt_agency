package com.uni.realt.service;

import com.uni.realt.entity.AgentEntity;

import java.util.List;

public interface AgentService {
    void save(AgentEntity agent) throws ServiceException;

    List<AgentEntity> getAllAgents() throws ServiceException;

    AgentEntity getAgentById(long id) throws ServiceException;

    void updateAgent(AgentEntity agent) throws ServiceException;

    void delete(long id) throws ServiceException;
}
