package com.uni.realt.dao;

import com.uni.realt.entity.AgentEntity;

import java.util.List;

public interface AgentDAO {
    void save(AgentEntity agent) throws DAOException;

    List<AgentEntity> getAllAgents() throws DAOException;

    AgentEntity getAgentById(long id) throws DAOException;

    void updateAgent(AgentEntity agent) throws DAOException;

    void delete(long id) throws DAOException;
}
