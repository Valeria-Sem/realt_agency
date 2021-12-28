package com.uni.realt.entity;

import java.io.Serializable;
import java.util.Objects;

public class AgentEntity implements Serializable {
    private long id;
    private String fio;

    public AgentEntity() {
    }

    public AgentEntity(String fio) {
        this.fio = fio;
    }

    public AgentEntity(long id, String fio) {
        this.id = id;
        this.fio = fio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgentEntity that = (AgentEntity) o;
        return id == that.id && fio.equals(that.fio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fio);
    }

    @Override
    public String toString() {
        return "AgentEntity{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                '}';
    }
}
