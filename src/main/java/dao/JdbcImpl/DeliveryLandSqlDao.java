package dao.JdbcImpl;

import dao.TransactionManager;
import dao.interfaces.DeliveryLandDao;

import dao.mappers.DeliveryLandMapper;
import model.DeliveryLand;

import java.util.List;

public class DeliveryLandSqlDao extends AbstractSqlDao<DeliveryLand> implements DeliveryLandDao {
    public DeliveryLandSqlDao(TransactionManager transactionManager) {
        super(transactionManager);
    }

    public static final String DELIVERY_LAND_TABLE = "delivery_land";
    public static final String DELIVERY_LAND_COLUMN_ID = "delivery_land_id";
    public static final String DELIVERY_LAND_COLUMN_COMPANY_ID = "company_id";
    public static final String DELIVERY_LAND_COLUMN__COST= "cost_perkm";
    public static final String DELIVERY_LAND_COLUMN__CONTAINER_ID = "container_id";


    public static final String SELECT_ALL = "SELECT * FROM " + DELIVERY_LAND_TABLE;
    public static final String SELECT_BY_TYPE_AND_COMPANY = "SELECT * FROM delivery_land  LEFT JOIN company  ON delivery_land.company_id = company.company_id JOIN container on delivery_land.container_id= container.container_id where container.container_type = ? AND company.name = ?";

    @Override
    public int create(DeliveryLand deliveryLand) {
        return 0;
    }

    @Override
    public boolean update(DeliveryLand deliveryLand) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<DeliveryLand> findAll() {
        return findAll(SELECT_ALL, new DeliveryLandMapper());
    }

    @Override
    public DeliveryLand findByContainerTypeAndCompany(String containerType, String companyName) {
        return find(SELECT_BY_TYPE_AND_COMPANY, preparedStatement ->  {
            preparedStatement.setString(1, containerType);
            preparedStatement.setString(2, companyName);
        }, new DeliveryLandMapper());
    }
}
