package com.uni.realt.service.impl;

import com.uni.realt.dao.ClientDAO;
import com.uni.realt.dao.DAOException;
import com.uni.realt.dao.DAOProvider;
import com.uni.realt.dao.OperationDAO;
import com.uni.realt.entity.ClientEntity;
import com.uni.realt.entity.OperationEntity;
import com.uni.realt.service.ClientService;
import com.uni.realt.service.ServiceException;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    @Override
    public void save(ClientEntity client) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        ClientDAO clientDAO = provider.getClientDAO();

        try{
            clientDAO.save(client);

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<ClientEntity> getAllClients() throws ServiceException {
        List<ClientEntity> clients;

        DAOProvider provider = DAOProvider.getInstance();
        ClientDAO clientDAO = provider.getClientDAO();

        try{
            clients = clientDAO.getAllClients();

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }

        return clients;
    }

    @Override
    public ClientEntity getClientById(long id) throws ServiceException {
        ClientEntity client;

        DAOProvider provider = DAOProvider.getInstance();
        ClientDAO clientDAO = provider.getClientDAO();

        try{
            client = clientDAO.getClientById(id);

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }

        return client;
    }

    @Override
    public void updateClient(ClientEntity client) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        ClientDAO clientDAO = provider.getClientDAO();

        try{
            clientDAO.updateClient(client);

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void delete(long id) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        ClientDAO clientDAO = provider.getClientDAO();

        try{
            clientDAO.delete(id);

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }
    }
}
