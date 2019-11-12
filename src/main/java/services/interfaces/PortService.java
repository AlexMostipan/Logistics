package services.interfaces;

import model.Port;

import java.util.List;

public interface PortService {
    int create(Port port);

    boolean update(Port port);

    boolean delete(int id);

    List<Port> findAll();

    List<Port> findByCountry(String country);
}
