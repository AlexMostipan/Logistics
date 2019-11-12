package dao.JdbcImpl;

import dao.TransactionManager;
import dao.interfaces.CompanyDao;
import dao.mappers.CompanyMapper;
import model.Сompany;

import java.util.List;

public class CompanySqlDao extends AbstractSqlDao<Сompany> implements CompanyDao {
    public CompanySqlDao(TransactionManager transactionManager) {
        super(transactionManager);
    }
    public static final String COMPANY_TABLE = "company";
    public static final String COMPANY_COLUMN_ID = "company_id";
    public static final String COMPANY_COLUMN__NAME = "name";
    public static final String COMPANY_COLUMN__COMPANY_TYPE= "company_type";


    public static final String SELECT_ALL = "SELECT * FROM " + COMPANY_TABLE;
    public static final String SELECT_BY_COMPANY_TYPE = "SELECT * FROM " + COMPANY_TABLE + " where " + COMPANY_COLUMN__COMPANY_TYPE + " = ?";

    @Override
    public int create(Сompany port) {
        return 0;
    }

    @Override
    public boolean update(Сompany port) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Сompany> findAll() {
        return findAll(SELECT_ALL, new CompanyMapper());
    }

    @Override
    public List<Сompany> findByCompanyType(String companyType) {
        return findAll(SELECT_BY_COMPANY_TYPE, preparedStatement -> preparedStatement.setString(1, companyType), new CompanyMapper());

    }
}
