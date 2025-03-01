package by.alst.project.jdbc.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<K, E> {
    boolean update(E e);

    Optional<E> findById(K k);

    List<E> findAll();

    E save(E e);

    boolean delete(K k);
}
