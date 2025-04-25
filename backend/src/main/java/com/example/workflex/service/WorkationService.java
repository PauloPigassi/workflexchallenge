package com.example.workflex.service;

import com.example.workflex.model.entities.Workation;

import java.util.List;

public interface WorkationService {
    List<Workation> getWorkations();
    void importCSV();
    long count();
}