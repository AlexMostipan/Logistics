package services.impl;

import dao.TransactionManager;
import dao.interfaces.LoadingDao;
import model.Loading;
import services.interfaces.LoadingService;

import java.util.List;

public class LoadingServiceImpl implements LoadingService {
    private LoadingDao loadingDao;
    private TransactionManager transactionManager;

    public LoadingServiceImpl(LoadingDao loadingDao, TransactionManager transactionManager) {
        this.loadingDao = loadingDao;
        this.transactionManager = transactionManager;
    }

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
        transactionManager.getConnection();
        try {
            return loadingDao.findAll();
        } finally {
            transactionManager.closeConnection();
        }
    }

    @Override
    public Loading findByContainerTypeAndPort(String containerType, String portName) {
        transactionManager.getConnection();
        try {
            return loadingDao.findByContainerTypeAndPort(containerType, portName);
        } finally {
            transactionManager.closeConnection();
        }
    }

}
