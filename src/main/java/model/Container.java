package model;



import java.util.Objects;

public class Container {
    private int id;
    private String containerType;
    private int maxWeight;

    public Container() {
    }

    public Container(int id, String containerType, int maxWeight) {
        this.id = id;
        this.containerType = containerType;
        this.maxWeight = maxWeight;
    }

    public Container(String containerType, int maxWeight) {
        this.containerType = containerType;
        this.maxWeight = maxWeight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return id == container.id &&
                maxWeight == container.maxWeight &&
                Objects.equals(containerType, container.containerType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, containerType, maxWeight);
    }

    @Override
    public String toString() {
        return "Container{" +
                "id=" + id +
                ", containerType='" + containerType + '\'' +
                ", maxWeight=" + maxWeight +
                '}';
    }
}
