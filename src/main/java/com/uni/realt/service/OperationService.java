package com.uni.realt.service;

import com.uni.realt.entity.OperationEntity;

import java.util.List;

public interface OperationService {
    void save(OperationEntity operation) throws ServiceException;

    List<OperationEntity> getAllOperations() throws ServiceException;

    OperationEntity getOperationById(long id) throws ServiceException;

    void updateOperation(OperationEntity operation) throws ServiceException;

    void delete(long id) throws ServiceException;
}
