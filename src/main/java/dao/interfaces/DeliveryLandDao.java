package dao.interfaces;

import model.DeliveryLand;

import java.util.List;

public interface DeliveryLandDao  {
    int create(DeliveryLand deliveryLand);

    boolean update(DeliveryLand deliveryLand);

    boolean delete(int id);

    List<DeliveryLand> findAll();

    DeliveryLand findByContainerTypeAndCompany(String containerType, String companyName);
}
