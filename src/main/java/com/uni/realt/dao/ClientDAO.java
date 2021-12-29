package com.uni.realt.dao;

import com.uni.realt.entity.ClientEntity;

import java.util.List;

public interface ClientDAO {
    void save(ClientEntity client) throws DAOException;

    List<ClientEntity> getAllClients() throws DAOException;

    ClientEntity getClientById(long id) throws DAOException;

    void updateClient(ClientEntity client) throws DAOException;

    void delete(long id) throws DAOException;
}
