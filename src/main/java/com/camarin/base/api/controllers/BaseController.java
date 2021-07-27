package com.camarin.base.api.controllers;

import com.camarin.base.domain.services.IBaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class BaseController<T, I> implements IBaseController<T, I> {
    protected final IBaseService<T, I> service;

    public BaseController(IBaseService<T, I> service) {
        this.service = service;
    }

    @Override
    @GetMapping(path = "/all")
    public List<T> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping(path = "/get/{id}")
    public T get(@RequestParam Long id) {
        return service.get(id);
    }

    @Override
    @PostMapping(path = "/create")
    public T create(@RequestBody T dto) {
        return service.create(dto);
    }

    @Override
    @PostMapping(path = "/save")
    public T save(@RequestBody T dto) {
        return service.save(dto);
    }

    @Override
    @PutMapping(path = "/delete/{id}")
    public Boolean delete(@RequestParam I id) {
        try {
            service.delete(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
