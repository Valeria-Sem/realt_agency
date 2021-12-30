package com.uni.realt.entity;

import java.io.Serializable;
import java.util.Objects;

public class OrderEntity implements Serializable {
    private long id;
    private String client;
    private String operation;
    private String agent;

    public OrderEntity() {
    }

    public OrderEntity(String client, String operation, String agent) {
        this.client = client;
        this.operation = operation;
        this.agent = agent;
    }

    public OrderEntity(long id, String client, String operation, String agent) {
        this.id = id;
        this.client = client;
        this.operation = operation;
        this.agent = agent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return id == that.id && client.equals(that.client) && operation.equals(that.operation) && agent.equals(that.agent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, operation, agent);
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", operation='" + operation + '\'' +
                ", agent='" + agent + '\'' +
                '}';
    }
}

