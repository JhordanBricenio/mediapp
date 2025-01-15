package com.codej.service.impl;

import com.codej.repository.IGenericRepository;
import com.codej.service.ICRUDGeneric;

import java.util.List;

public abstract class CRUDGenericImp<T, ID> implements ICRUDGeneric<T, ID> {

    protected  abstract IGenericRepository<T, ID> getRepository();

    @Override
    public T save(T t) throws Exception {
        return getRepository().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        return getRepository().save(t);
    }

    @Override
    public List<T>  findAll() throws Exception {
        return getRepository().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepository().findById(id).orElse(null);
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepository().deleteById(id);
    }

}
