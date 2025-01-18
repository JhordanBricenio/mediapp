package com.codej.service.impl;

import com.codej.model.Exam;
import com.codej.repository.IExamRepository;
import com.codej.repository.IGenericRepository;
import com.codej.service.IExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl extends CRUDGenericImp<Exam, UUID> implements IExamService {

    private  final IExamRepository examRepository;
    @Override
    protected IGenericRepository<Exam, UUID> getRepository() {
        return examRepository;
    }
}
