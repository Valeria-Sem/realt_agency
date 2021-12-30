package com.uni.realt.service.impl;

import com.uni.realt.dao.DAOException;
import com.uni.realt.dao.DAOProvider;
import com.uni.realt.dao.OperationDAO;
import com.uni.realt.dao.OrderDAO;
import com.uni.realt.entity.OperationEntity;
import com.uni.realt.entity.OrderEntity;
import com.uni.realt.service.OperationService;
import com.uni.realt.service.ServiceException;

import java.util.List;

public class OperationServiceImpl implements OperationService {

    @Override
    public void save(OperationEntity operation) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        OperationDAO operationDAO = provider.getOperationDAO();

        try{
            operationDAO.save(operation);

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<OperationEntity> getAllOperations() throws ServiceException {
        List<OperationEntity> operations;

        DAOProvider provider = DAOProvider.getInstance();
        OperationDAO operationDAO = provider.getOperationDAO();

        try{
            operations = operationDAO.getAllOperations();

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }

        return operations;
    }

    @Override
    public OperationEntity getOperationById(long id) throws ServiceException {
        OperationEntity operation;

        DAOProvider provider = DAOProvider.getInstance();
        OperationDAO operationDAO = provider.getOperationDAO();

        try{
            operation = operationDAO.getOperationById(id);

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }

        return operation;
    }

    @Override
    public void updateOperation(OperationEntity operation) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        OperationDAO operationDAO = provider.getOperationDAO();

        try{
            operationDAO.updateOperation(operation);

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void delete(long id) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        OperationDAO operationDAO = provider.getOperationDAO();

        try{
            operationDAO.delete(id);

        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }
    }
}
