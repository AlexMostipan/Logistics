package services.interfaces;

import model.DeliverySea;

import java.util.List;

public interface DeliverySeaService {
    int create(DeliverySea deliverySea);

    boolean update(DeliverySea deliverySea);

    boolean delete(int id);

    List<DeliverySea> findAll();

    DeliverySea findByContainerTypeAndCompany(String containerType, String companyName);
}
