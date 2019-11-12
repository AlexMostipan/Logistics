package model;

import java.util.Objects;

public class Loading {
    private int id;
    private int portId;
    private int cost;
    private int containerId;

    public Loading() {
    }

    public Loading(int id, int portId, int cost, int containerId) {
        this.id = id;
        this.portId = portId;
        this.cost = cost;
        this.containerId = containerId;
    }

    public Loading(int portId, int cost, int containerId) {
        this.portId = portId;
        this.cost = cost;
        this.containerId = containerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPortId() {
        return portId;
    }

    public void setPortId(int portId) {
        this.portId = portId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getContainerId() {
        return containerId;
    }

    public void setContainerId(int containerId) {
        this.containerId = containerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loading loading = (Loading) o;
        return id == loading.id &&
                portId == loading.portId &&
                cost == loading.cost &&
                containerId == loading.containerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, portId, cost, containerId);
    }

    @Override
    public String toString() {
        return "Loading{" +
                "id=" + id +
                ", portId=" + portId +
                ", cost=" + cost +
                ", containerId=" + containerId +
                '}';
    }
}
