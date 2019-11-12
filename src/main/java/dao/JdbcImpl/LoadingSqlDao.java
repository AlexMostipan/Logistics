package dao.JdbcImpl;

import dao.TransactionManager;
import dao.interfaces.LoadingDao;
import dao.mappers.LoadingMapper;
import model.Loading;
import services.interfaces.LoadingService;

import java.util.List;

public class LoadingSqlDao extends AbstractSqlDao<Loading> implements LoadingDao {
    public LoadingSqlDao(TransactionManager transactionManager) {
        super(transactionManager);
    }

    public static final String LOADING_TABLE = "loading";
    public static final String LOADING_COLUMN_ID = "loading_id";
    public static final String LOADING_COLUMN_PORT_ID = "port_id";
    public static final String LOADING_COLUMN__CONTAINER_ID = "container_id";
    public static final String LOADING_COLUMN__COST= "cost";


    public static final String SELECT_ALL = "SELECT * FROM " + LOADING_TABLE;
    public static final String SELECT_BY_TYPE_AND_PORT = "SELECT * FROM loading  LEFT JOIN port  ON loading.port_id = port.port_id JOIN container on loading.container_id= container.container_id where container.container_type = ? AND port.name = ?";

    @Override
    public int create(Loading loading) {
        return 0;
    }

    @Override
    public boolean update(Loading loading) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Loading> findAll() {
        return findAll(SELECT_ALL, new LoadingMapper());
    }

    @Override
    public Loading findByContainerTypeAndPort(String containerType, String portName) {
        return  find(SELECT_BY_TYPE_AND_PORT, preparedStatement ->  {
            preparedStatement.setString(1, containerType);
            preparedStatement.setString(2, portName);
        }, new LoadingMapper());
    }
}
