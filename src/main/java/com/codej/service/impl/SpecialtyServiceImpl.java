package com.codej.service.impl;

import com.codej.model.Specialty;
import com.codej.repository.ISpecialtyRepository;
import com.codej.repository.IGenericRepository;
import com.codej.service.ISpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SpecialtyServiceImpl extends CRUDGenericImp<Specialty, UUID> implements ISpecialtyService {

    private  final ISpecialtyRepository SpecialtyRepository;
    @Override
    protected IGenericRepository<Specialty, UUID> getRepository() {
        return SpecialtyRepository;
    }
}
