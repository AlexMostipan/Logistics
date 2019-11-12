package services.impl;

import dao.TransactionManager;
import dao.interfaces.PortDao;
import model.Port;
import services.interfaces.PortService;

import java.util.List;

public class PortServiceImpl implements PortService {
    private PortDao portDao;
    private TransactionManager transactionManager;

    public PortServiceImpl(PortDao portDao, TransactionManager transactionManager) {
        this.portDao = portDao;
        this.transactionManager = transactionManager;
    }

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
        transactionManager.getConnection();
        try {
            return portDao.findAll();
        } finally {
            transactionManager.closeConnection();
        }
    }

    @Override
    public List<Port> findByCountry(String country) {
        transactionManager.getConnection();
        try {
            return portDao.findByCountry(country);
        } finally {
            transactionManager.closeConnection();
        }
    }
}

