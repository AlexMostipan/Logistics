package dao.mappers;

import dao.JdbcImpl.LoadingSqlDao;
import model.Loading;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadingMapper implements Mapper<Loading> {

    @Override
    public Loading getEntity(ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            return null;
        }
        return new Loading(resultSet.getInt(LoadingSqlDao.LOADING_COLUMN_ID),
                resultSet.getInt(LoadingSqlDao.LOADING_COLUMN_PORT_ID),
                resultSet.getInt(LoadingSqlDao.LOADING_COLUMN__COST),
                resultSet.getInt(LoadingSqlDao.LOADING_COLUMN__CONTAINER_ID)
        );
    }
}
