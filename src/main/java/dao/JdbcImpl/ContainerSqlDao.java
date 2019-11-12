package dao.JdbcImpl;

import dao.TransactionManager;
import dao.interfaces.ContainerDao;
import dao.mappers.ContainerMapper;
import model.Container;

import java.util.List;

public class ContainerSqlDao extends AbstractSqlDao<Container> implements ContainerDao {
    public ContainerSqlDao(TransactionManager transactionManager) {
        super(transactionManager);
    }

    public static final String CONTAINER_TABLE = "container";
    public static final String CONTAINER_COLUMN_ID = "container_id";
    public static final String CONTAINER_COLUMN__TYPE = "container_type";
    public static final String CONTAINER_COLUMN__WEIGHT = "max_weight";


    public static final String SELECT_ALL = "SELECT * FROM " + CONTAINER_TABLE;
    public static final String SELECT_BY_TYPE = "SELECT * FROM " + CONTAINER_TABLE + " where " + CONTAINER_COLUMN__TYPE + " = ?";

    @Override
    public int create(Container container) {
        return 0;
    }

    @Override
    public boolean update(Container container) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Container> findAll() {
        return findAll(SELECT_ALL, new ContainerMapper());
    }

    @Override
    public Container findByType(String containerType) {
        return find(SELECT_BY_TYPE, preparedStatement -> preparedStatement.setString(1, containerType), new ContainerMapper());
    }
}
