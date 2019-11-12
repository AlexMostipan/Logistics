package model;

import java.util.Objects;

public class Unloading {
    private int id;
    private int portId;
    private int cost;
    private int containerId;

    public Unloading() {
    }

    public Unloading(int portId, int cost, int containerId) {
        this.portId = portId;
        this.cost = cost;
        this.containerId = containerId;
    }

    public Unloading(int id, int portId, int cost, int containerId) {
        this.id = id;
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
        Unloading unloading = (Unloading) o;
        return id == unloading.id &&
                portId == unloading.portId &&
                cost == unloading.cost &&
                containerId == unloading.containerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, portId, cost, containerId);
    }

    @Override
    public String toString() {
        return "Unloading{" +
                "id=" + id +
                ", portId=" + portId +
                ", cost=" + cost +
                ", containerId=" + containerId +
                '}';
    }
}

