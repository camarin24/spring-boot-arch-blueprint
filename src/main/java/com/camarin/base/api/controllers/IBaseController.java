package com.camarin.base.api.controllers;

import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface IBaseController<T, I> {
    List<T> getAll();

    T get(Long id);

    T create(T dto);

    T save(T dto);

    Boolean delete(I id);
}
