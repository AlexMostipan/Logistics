package model;

import model.enums.CompanyType;

import java.util.Objects;

public class Сompany {
    private int id;
    private String name;
    private CompanyType companyType;

    public Сompany() {
    }

    public Сompany(String name, CompanyType companyType) {
        this.name = name;
        this.companyType = companyType;
    }

    public Сompany(int id, String name, CompanyType companyType) {
        this.id = id;
        this.name = name;
        this.companyType = companyType;
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

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Сompany сompany = (Сompany) o;
        return id == сompany.id &&
                Objects.equals(name, сompany.name) &&
                companyType == сompany.companyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, companyType);
    }

    @Override
    public String toString() {
        return "Сompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyType=" + companyType +
                '}';
    }
}
