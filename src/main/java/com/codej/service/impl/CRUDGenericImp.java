package com.codej.service.impl;

import com.codej.exception.ModelNotFoundException;
import com.codej.repository.IGenericRepository;
import com.codej.service.ICRUDGeneric;

import java.util.List;

import static com.codej.constants.ErrorMessageConstants.NOT_RESULTS_FOUND_ID;


public abstract class CRUDGenericImp<T, ID> implements ICRUDGeneric<T, ID> {

    protected  abstract IGenericRepository<T, ID> getRepository();

    @Override
    public T save(T t) throws Exception {
        return getRepository().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        getRepository().findById(id).orElseThrow(
                ()-> new ModelNotFoundException(NOT_RESULTS_FOUND_ID+ id));
        return getRepository().save(t);
    }

    @Override
    public List<T>  findAll() throws Exception {
        return getRepository().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepository().findById(id).orElseThrow(
                ()-> new ModelNotFoundException(NOT_RESULTS_FOUND_ID+ id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepository().findById(id).orElseThrow(
                ()-> new ModelNotFoundException(NOT_RESULTS_FOUND_ID+ id));
        getRepository().deleteById(id);
    }

}
