package services.interfaces;

import model.Loading;

import java.util.List;

public interface LoadingService {
    int create(Loading loading);

    boolean update(Loading loading);

    boolean delete(int id);

    List<Loading> findAll();

    Loading findByContainerTypeAndPort(String containerType, String portName);
}
