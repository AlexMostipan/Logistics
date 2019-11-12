package dao.interfaces;

import model.Unloading;

import java.util.List;

public interface UnloadingDao {
    int create(Unloading unloading);

    boolean update(Unloading unloading);

    boolean delete(int id);

    List<Unloading> findAll();

    Unloading findByContainerTypeAndPort(String containerType, String portName);
}
