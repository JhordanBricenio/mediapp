package com.codej.service.impl;

import com.codej.model.Medic;
import com.codej.repository.IGenericRepository;
import com.codej.repository.IMedicRepository;
import com.codej.service.IMedicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MedicServiceImpl extends CRUDGenericImp<Medic, UUID> implements IMedicService {

    private  final IMedicRepository medicRepository;
    @Override
    protected IGenericRepository<Medic, UUID> getRepository() {
        return medicRepository;
    }
}
