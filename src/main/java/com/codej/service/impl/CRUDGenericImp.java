package com.codej.service.impl;

import com.codej.exception.ModelNotFoundException;
import com.codej.repository.IGenericRepository;
import com.codej.service.ICRUDGeneric;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.List;

import static com.codej.constants.ErrorMessageConstants.NOT_RESULTS_FOUND_ID;

@Slf4j
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

        //Java Reflection
        Class<?> clazz = t.getClass();
        String className = clazz.getSimpleName();
        String methodName= "setId"+ className;
        Method setIdMethod = clazz.getMethod(methodName, id.getClass());

        setIdMethod.invoke(t, id);
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
