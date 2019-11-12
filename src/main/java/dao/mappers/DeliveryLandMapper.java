package dao.mappers;

import dao.JdbcImpl.DeliveryLandSqlDao;
import model.DeliveryLand;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryLandMapper implements Mapper<DeliveryLand> {

    @Override
    public DeliveryLand getEntity(ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            return null;
        }
        return new DeliveryLand(resultSet.getInt(DeliveryLandSqlDao.DELIVERY_LAND_COLUMN_ID),
                resultSet.getInt(DeliveryLandSqlDao.DELIVERY_LAND_COLUMN_COMPANY_ID),
                resultSet.getInt(DeliveryLandSqlDao.DELIVERY_LAND_COLUMN__COST),
                        resultSet.getInt(DeliveryLandSqlDao.DELIVERY_LAND_COLUMN__CONTAINER_ID)
        );
    }
}

