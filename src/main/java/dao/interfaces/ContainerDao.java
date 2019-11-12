package dao.interfaces;

import model.Container;

import java.util.List;

public interface ContainerDao {
    int create(Container container);

    boolean update(Container container);

    boolean delete(int id);

    List<Container> findAll();

    Container findByType(String containerType);
}
