package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.JdbcImpl.CompanySqlDao;
import model.Сompany;
import model.enums.CompanyType;
public class CompanyMapper implements Mapper<Сompany> {

    @Override
    public Сompany getEntity(ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            return null;
        }
        return new Сompany(resultSet.getInt(CompanySqlDao.COMPANY_COLUMN_ID),
                resultSet.getString(CompanySqlDao.COMPANY_COLUMN__NAME),
                CompanyType.valueOf(resultSet.getString(CompanySqlDao.COMPANY_COLUMN__COMPANY_TYPE))
        );
    }
}
