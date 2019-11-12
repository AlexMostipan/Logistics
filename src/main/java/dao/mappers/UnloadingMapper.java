package dao.mappers;

import dao.JdbcImpl.UnloadingSqlDao;
import model.Unloading;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UnloadingMapper implements Mapper<Unloading> {

    @Override
    public Unloading getEntity(ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            return null;
        }
        return new Unloading(resultSet.getInt(UnloadingSqlDao.UNLOADING_COLUMN_ID),
                resultSet.getInt(UnloadingSqlDao.UNLOADING_COLUMN_PORT_ID),
                resultSet.getInt(UnloadingSqlDao.UNLOADING_COLUMN__COST),
                resultSet.getInt(UnloadingSqlDao.UNLOADING_COLUMN__CONTAINER_ID)
        );
    }
}

