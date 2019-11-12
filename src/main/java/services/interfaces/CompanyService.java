package services.interfaces;

import model.Сompany;

import java.util.List;

public interface CompanyService {
    int create(Сompany port);

    boolean update(Сompany port);

    boolean delete(int id);

    List<Сompany> findAll();
    List<Сompany> findByCompanyType(String companyType);
}
