package services.impl;

import dao.TransactionManager;
import dao.interfaces.PortDao;
import dao.interfaces.UnloadingDao;
import model.Unloading;
import services.interfaces.UnloadingService;

import java.util.List;

public class UnloadingServiceIml implements UnloadingService {
    private UnloadingDao unloadingDao;
    private TransactionManager transactionManager;

    public UnloadingServiceIml(UnloadingDao unloadingDao, TransactionManager transactionManager) {
        this.unloadingDao = unloadingDao;
        this.transactionManager = transactionManager;
    }

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
        transactionManager.getConnection();
        try {
            return unloadingDao.findAll();
        } finally {
            transactionManager.closeConnection();
        }
    }

    @Override
    public Unloading findByContainerTypeAndPort(String containerType, String portName) {
        transactionManager.getConnection();
        try {
            return unloadingDao.findByContainerTypeAndPort(containerType, portName);
        } finally {
            transactionManager.closeConnection();
        }
    }
}
