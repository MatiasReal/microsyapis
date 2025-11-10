package com.clinica.ClinicaOdontologica.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

    void saveOne(T t);
}
