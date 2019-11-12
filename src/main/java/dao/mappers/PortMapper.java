package dao.mappers;
import dao.JdbcImpl.PortSqlDao;
import model.Port;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PortMapper implements Mapper<Port> {

    @Override
    public Port getEntity(ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            return null;
        }
        return new Port(resultSet.getInt(PortSqlDao.PORT_COLUMN_ID),
                resultSet.getString(PortSqlDao.PORT_COLUMN__NAME),
                resultSet.getString(PortSqlDao.PORT_COLUMN__CITY),
                resultSet.getString(PortSqlDao.PORT_COLUMN__COUNTRY)
        );
    }
}
