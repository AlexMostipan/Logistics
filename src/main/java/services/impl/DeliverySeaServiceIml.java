package services.impl;

import dao.TransactionManager;
import dao.interfaces.DeliverySeaDao;
import model.DeliverySea;
import services.interfaces.DeliverySeaService;

import java.util.List;

public class DeliverySeaServiceIml implements DeliverySeaService {
    private DeliverySeaDao deliverySeaDao;
    private TransactionManager transactionManager;

    public DeliverySeaServiceIml(DeliverySeaDao deliverySeaDao, TransactionManager transactionManager) {
        this.deliverySeaDao = deliverySeaDao;
        this.transactionManager = transactionManager;
    }

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
        transactionManager.getConnection();
        try {
            return deliverySeaDao.findAll();
        } finally {
            transactionManager.closeConnection();
        }
    }

    @Override
    public DeliverySea findByContainerTypeAndCompany(String containerType, String companyName) {
        transactionManager.getConnection();
        try {
            return deliverySeaDao.findByContainerTypeAndCompany(containerType,companyName);
        } finally {
            transactionManager.closeConnection();
        }
    }
}
