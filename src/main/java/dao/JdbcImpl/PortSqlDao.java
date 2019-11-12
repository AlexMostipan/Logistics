package dao.JdbcImpl;

import dao.TransactionManager;
import dao.interfaces.PortDao;
import dao.mappers.PortMapper;
import model.Port;

import java.util.List;

public class PortSqlDao extends AbstractSqlDao<Port> implements PortDao {
    public PortSqlDao(TransactionManager transactionManager) {
        super(transactionManager);
    }

    public static final String PORT_TABLE = "port";
    public static final String PORT_COLUMN_ID = "port_id";
    public static final String PORT_COLUMN__NAME = "name";
    public static final String PORT_COLUMN__CITY = "city";
    public static final String PORT_COLUMN__COUNTRY = "country";

    public static final String SELECT_ALL = "SELECT * FROM " + PORT_TABLE;
    public static final String SELECT_BY_COUNTRY = "SELECT * FROM " + PORT_TABLE + " where " + PORT_COLUMN__COUNTRY + " = ?";

    @Override
    public int create(Port port) {
        return 0;
    }

    @Override
    public boolean update(Port port) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Port> findAll() {
        return findAll(SELECT_ALL, new PortMapper());
    }

    @Override
    public List<Port> findByCountry(String country) {
        return findAll(SELECT_BY_COUNTRY, preparedStatement -> preparedStatement.setString(1, country), new PortMapper());
    }
}
