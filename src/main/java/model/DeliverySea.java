package model;

import java.util.Objects;

public class DeliverySea {
    private int id;
    private int companyId;
    private int cost;
    private int containerId;

    public DeliverySea() {
    }

    public DeliverySea(int companyId, int cost, int containerId) {
        this.companyId = companyId;
        this.cost = cost;
        this.containerId = containerId;
    }

    public DeliverySea(int id, int companyId, int cost, int containerId) {
        this.id = id;
        this.companyId = companyId;
        this.cost = cost;
        this.containerId = containerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
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
        DeliverySea that = (DeliverySea) o;
        return id == that.id &&
                companyId == that.companyId &&
                cost == that.cost &&
                containerId == that.containerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyId, cost, containerId);
    }

    @Override
    public String toString() {
        return "DeliverySea{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", cost=" + cost +
                ", containerId=" + containerId +
                '}';
    }
}
