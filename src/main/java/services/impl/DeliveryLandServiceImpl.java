package services.impl;

import dao.TransactionManager;
import dao.interfaces.DeliveryLandDao;
import model.DeliveryLand;
import services.interfaces.DeliveryLandService;

import java.util.List;

public class DeliveryLandServiceImpl implements DeliveryLandService {
    private DeliveryLandDao deliveryLandDao;
    private TransactionManager transactionManager;

    public DeliveryLandServiceImpl(DeliveryLandDao deliveryLandDao, TransactionManager transactionManager) {
        this.deliveryLandDao = deliveryLandDao;
        this.transactionManager = transactionManager;
    }

    @Override
    public int create(DeliveryLand deliveryLand) {
        return 0;
    }

    @Override
    public boolean update(DeliveryLand deliveryLand) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<DeliveryLand> findAll() {
        transactionManager.getConnection();
        try {
            return deliveryLandDao.findAll();
        } finally {
            transactionManager.closeConnection();
        }
    }

    @Override
    public DeliveryLand findByContainerTypeAndCompany(String containerType, String companyName) {
        try {
            return deliveryLandDao.findByContainerTypeAndCompany(containerType,companyName );
        } finally {
            transactionManager.closeConnection();
        }
    }
}
