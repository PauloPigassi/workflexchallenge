package com.example.workflex.controller;

import com.example.workflex.model.entities.Workation;
import com.example.workflex.service.impl.WorkationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workflex")
@RequiredArgsConstructor
public class WorkationController {


    @Autowired
    private WorkationServiceImpl workationServiceImpl;

    @GetMapping("/workation")
    public List<Workation> getWorkations() {

        if (workationServiceImpl.count() == 0) { // Will call just the first time
            workationServiceImpl.importCSV(); // call CSV import
        }
        return workationServiceImpl.getWorkations();
    }

}
