package dao.mappers;

import dao.JdbcImpl.DeliverySeaSqlDao;
import model.DeliverySea;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliverySeaMapper implements Mapper<DeliverySea> {

    @Override
    public DeliverySea getEntity(ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            return null;
        }
        return new DeliverySea(resultSet.getInt(DeliverySeaSqlDao.DELIVERY_SEA_COLUMN_ID),
                resultSet.getInt(DeliverySeaSqlDao.DELIVERY_SEA_COLUMN_COMPANY_ID),
                resultSet.getInt(DeliverySeaSqlDao.DELIVERY_SEA_COLUMN__COST),
                resultSet.getInt(DeliverySeaSqlDao.DELIVERY_SEA_COLUMN__CONTAINER_ID)
        );
    }
}
