package com.example.kt_model_3.service;

import java.util.List;

public interface GenneralDAO <E> {
    List<E> findAllPhongTro(String keyword);
    void savePhongTro(E entity);
   E findById(int id);
}
