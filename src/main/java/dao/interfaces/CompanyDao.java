package dao.interfaces;

import java.util.List;
import model.Сompany;

public interface CompanyDao {
    int create(Сompany port);

    boolean update(Сompany port);

    boolean delete(int id);

    List<Сompany> findAll();
    List<Сompany> findByCompanyType(String companyType);
}
