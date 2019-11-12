package dao.mappers;

import dao.JdbcImpl.ContainerSqlDao;
import model.Container;


import java.sql.ResultSet;
import java.sql.SQLException;

public class ContainerMapper implements Mapper<Container> {

    @Override
    public Container getEntity(ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            return null;
        }
        return new Container(resultSet.getInt(ContainerSqlDao.CONTAINER_COLUMN_ID),
                (resultSet.getString(ContainerSqlDao.CONTAINER_COLUMN__TYPE)),
                resultSet.getInt(ContainerSqlDao.CONTAINER_COLUMN__WEIGHT)
        );
    }
}
