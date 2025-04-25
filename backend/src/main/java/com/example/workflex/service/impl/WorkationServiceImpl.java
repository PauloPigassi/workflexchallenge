package com.example.workflex.service.impl;


import com.example.workflex.model.entities.Workation;
import com.example.workflex.repository.WorkationRepository;
import com.example.workflex.service.WorkationService;
import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkationServiceImpl implements WorkationService {

    private final WorkationRepository workationRepository;

    @Override
    public List<Workation> getWorkations() {
        return workationRepository.findAll();
    }

    @Override
    public void importCSV() {
        try {
            ClassPathResource resource = new ClassPathResource("workations.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(resource.getInputStream()));
            String[] line;
            List<Workation> workations = new ArrayList<>();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            reader.readNext(); // skip header

            while ((line = reader.readNext()) != null) {
                Workation w = Workation.builder()
                        .workationId(line[0])
                        .employee(line[1])
                        .origin(line[2].trim())
                        .destination(line[3].trim())
                        .startDate(LocalDate.parse(line[4], formatter))
                        .endDate(LocalDate.parse(line[5], formatter))
                        .workingDays(Integer.parseInt(line[6]))
                        .risk(line[7])
                        .build();
                workations.add(w);
            }

            workationRepository.saveAll(workations);
        } catch (Exception e) {
            throw new RuntimeException("Error importing CSV: " + e.getMessage(), e);
        }
    }

    @Override
    public long count() {
        return workationRepository.count();
    }
}
