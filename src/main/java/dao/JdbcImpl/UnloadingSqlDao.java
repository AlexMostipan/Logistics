package dao.JdbcImpl;

import dao.TransactionManager;
import dao.interfaces.UnloadingDao;
import dao.mappers.UnloadingMapper;
import model.Unloading;

import java.util.List;

public class UnloadingSqlDao extends AbstractSqlDao<Unloading>  implements UnloadingDao {
    public UnloadingSqlDao(TransactionManager transactionManager) {
        super(transactionManager);
    }

    public static final String UNLOADING_TABLE = "unloading";
    public static final String UNLOADING_COLUMN_ID = "unloading_id";
    public static final String UNLOADING_COLUMN_PORT_ID = "port_id";
    public static final String UNLOADING_COLUMN__CONTAINER_ID = "container_id";
    public static final String UNLOADING_COLUMN__COST= "cost";


    public static final String SELECT_ALL = "SELECT * FROM " + UNLOADING_TABLE;
    public static final String SELECT_BY_TYPE_AND_PORT = "SELECT * FROM unloading  LEFT JOIN port  ON unloading.port_id = port.port_id JOIN container on unloading.container_id= container.container_id where container.container_type = ? AND port.name = ?";

    @Override
    public int create(Unloading unloading) {
        return 0;
    }

    @Override
    public boolean update(Unloading unloading) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Unloading> findAll() {
        return findAll(SELECT_ALL, new UnloadingMapper());
    }

    @Override
    public Unloading findByContainerTypeAndPort(String containerType, String portName) {
        return  find(SELECT_BY_TYPE_AND_PORT, preparedStatement ->  {
            preparedStatement.setString(1, containerType);
            preparedStatement.setString(2, portName);
        }, new UnloadingMapper());
    }
}
