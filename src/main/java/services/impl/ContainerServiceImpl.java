package services.impl;

import dao.TransactionManager;
import dao.interfaces.ContainerDao;
import model.Container;
import services.interfaces.ContainerService;

import java.util.List;

public class ContainerServiceImpl implements ContainerService {
    private ContainerDao containerDao;
    private TransactionManager transactionManager;

    public ContainerServiceImpl(ContainerDao containerDao, TransactionManager transactionManager) {
        this.containerDao = containerDao;
        this.transactionManager = transactionManager;
    }

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
        transactionManager.getConnection();
        try {
            return containerDao.findAll();
        } finally {
            transactionManager.closeConnection();
        }
    }

    @Override
    public Container findByType(String containerType) {
        transactionManager.getConnection();
        try {
            return containerDao.findByType(containerType);
        } finally {
            transactionManager.closeConnection();
        }
    }
}
