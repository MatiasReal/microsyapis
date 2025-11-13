package com.clinica.ClinicaOdontologica.service;

import java.util.List;
import java.util.Optional;

public interface IService<T, ID> {
    List<T> findAll();

    Optional<T> findById(ID id);

    void saveOne(T t);

    void updateOne(T t);

    void deleteOne(ID id);
}
