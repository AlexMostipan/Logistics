package model;

import java.util.Objects;

public class Port {
    private int id;
    private String name;
    private String city;
    private String country;

    public Port() {
    }

    public Port(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public Port(int id, String name, String city, String country) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Port port = (Port) o;
        return id == port.id &&
                Objects.equals(name, port.name) &&
                Objects.equals(city, port.city) &&
                Objects.equals(country, port.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, country);
    }

    @Override
    public String toString() {
        return "Port{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
