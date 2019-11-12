package dao.JdbcImpl;

import dao.TransactionManager;
import dao.interfaces.DeliverySeaDao;
import dao.mappers.DeliverySeaMapper;
import model.DeliverySea;

import java.util.List;

public class DeliverySeaSqlDao extends AbstractSqlDao<DeliverySea> implements DeliverySeaDao {
    public DeliverySeaSqlDao(TransactionManager transactionManager) {
        super(transactionManager);
    }

    public static final String DELIVERY_SEA_TABLE = "delivery_sea";
    public static final String DELIVERY_SEA_COLUMN_ID = "delivery_sea_id";
    public static final String DELIVERY_SEA_COLUMN_COMPANY_ID = "company_id";
    public static final String DELIVERY_SEA_COLUMN__COST = "cost_perkm";
    public static final String DELIVERY_SEA_COLUMN__CONTAINER_ID = "container_id";


    public static final String SELECT_ALL = "SELECT * FROM " + DELIVERY_SEA_TABLE;
    public static final String SELECT_BY_TYPE_AND_COMPANY = "SELECT * FROM delivery_sea  LEFT JOIN company  ON delivery_sea.company_id = company.company_id JOIN container on delivery_sea.container_id= container.container_id where container.container_type = ? AND company.name = ?";

    @Override
    public int create(DeliverySea deliverySea) {
        return 0;
    }

    @Override
    public boolean update(DeliverySea deliverySea) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<DeliverySea> findAll() {
        return findAll(SELECT_ALL, new DeliverySeaMapper());
    }

    @Override
    public DeliverySea findByContainerTypeAndCompany(String containerType, String companyName) {
        return find(SELECT_BY_TYPE_AND_COMPANY, preparedStatement ->  {
            preparedStatement.setString(1, containerType);
            preparedStatement.setString(2, companyName);
        }, new DeliverySeaMapper());
    }
}
