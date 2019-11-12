package model;


import java.util.Objects;

public class Order {
    private int id;
    private int clientId;
    private String cityFrom;
    private String cityTo;
    private int loadingId;
    private int unLoadingId;
    private int deliveryLandId;
    private int deliverySeaId;
    private int allCost;

    public Order() {
    }

    public Order(int clientId, String cityFrom, String cityTo, int loadingId, int unLoadingId, int deliveryLandId, int deliverySeaId, int allCost) {
        this.clientId = clientId;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.loadingId = loadingId;
        this.unLoadingId = unLoadingId;
        this.deliveryLandId = deliveryLandId;
        this.deliverySeaId = deliverySeaId;
        this.allCost = allCost;
    }

    public Order(int id, int clientId, String cityFrom, String cityTo, int loadingId, int unLoadingId, int deliveryLandId, int deliverySeaId, int allCost) {
        this.id = id;
        this.clientId = clientId;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.loadingId = loadingId;
        this.unLoadingId = unLoadingId;
        this.deliveryLandId = deliveryLandId;
        this.deliverySeaId = deliverySeaId;
        this.allCost = allCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                clientId == order.clientId &&
                loadingId == order.loadingId &&
                unLoadingId == order.unLoadingId &&
                deliveryLandId == order.deliveryLandId &&
                deliverySeaId == order.deliverySeaId &&
                allCost == order.allCost &&
                Objects.equals(cityFrom, order.cityFrom) &&
                Objects.equals(cityTo, order.cityTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, cityFrom, cityTo, loadingId, unLoadingId, deliveryLandId, deliverySeaId, allCost);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", cityFrom='" + cityFrom + '\'' +
                ", cityTo='" + cityTo + '\'' +
                ", loadingId=" + loadingId +
                ", unLoadingId=" + unLoadingId +
                ", deliveryLandId=" + deliveryLandId +
                ", deliverySeaId=" + deliverySeaId +
                ", allCost=" + allCost +
                '}';
    }
}
