package com.camarin.base.domain.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService<D, E, I> implements IBaseService<D, I> {

    @Autowired
    private ModelMapper mapper;

    private final Class<D> dtoType;
    private final Class<E> entityType;
    private JpaRepository<E, I> repository;


    protected BaseService(JpaRepository<E, I> repository, Class<D> dtoType, Class<E> entityType) {
        this.repository = repository;
        this.dtoType = dtoType;
        this.entityType = entityType;
    }

    @Override
    public List<D> getAll() {
        List<E> data = repository.findAll();
        return this.mapList(data, dtoType);
    }

    @Override
    public D get(Long id) {
        return null;
    }

    @Override
    public D create(D dto) {
        E model = mapper.map(dto, entityType);
        E newEntry = this.repository.save(model);
        return mapper.map(newEntry, dtoType);
    }

    @Override
    public D save(D dto) {
        E model = mapper.map(dto, entityType);
        E newEntry = this.repository.save(model);
        return mapper.map(newEntry, dtoType);
    }

    @Override
    public void delete(I id) {
        this.repository.deleteById(id);
    }

    @Override
    public Long getTotal() {
        return this.repository.count();
    }

    protected <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source.stream().map(element -> mapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    protected D entityToDto(E entity) {
        return this.mapper.map(entity, this.dtoType);
    }

    protected E dtoToEntity(D dto) {
        return this.mapper.map(dto, this.entityType);
    }
}
