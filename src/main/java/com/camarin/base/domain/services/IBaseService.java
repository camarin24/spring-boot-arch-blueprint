package com.camarin.base.domain.services;

import java.util.List;

public interface IBaseService<T, I> {
    List<T> getAll();

    T get(Long id);

    T create(T dto);

    T save(T dto);

    void delete(I id);

    Long getTotal();
}
