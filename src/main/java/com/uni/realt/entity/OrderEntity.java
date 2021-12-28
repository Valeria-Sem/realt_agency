package com.uni.realt.entity;

import java.io.Serializable;
import java.util.Objects;

public class OrderEntity implements Serializable {
    private long id;
    private long clientId;
    private long operationId;
    private long agentId;

    public OrderEntity() {
    }

    public OrderEntity(long clientId, long operationId, long agentId) {
        this.clientId = clientId;
        this.operationId = operationId;
        this.agentId = agentId;
    }

    public OrderEntity(long id, long clientId, long operationId, long agentId) {
        this.id = id;
        this.clientId = clientId;
        this.operationId = operationId;
        this.agentId = agentId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getOperationId() {
        return operationId;
    }

    public void setOperationId(long operationId) {
        this.operationId = operationId;
    }

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return id == that.id && clientId == that.clientId && operationId == that.operationId && agentId == that.agentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, operationId, agentId);
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", operationId=" + operationId +
                ", agentId=" + agentId +
                '}';
    }
}

