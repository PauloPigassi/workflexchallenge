package com.example.workflex.integration;

import com.example.workflex.model.entities.Workation;
import com.example.workflex.repository.WorkationRepository;
import com.example.workflex.service.impl.WorkationServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class WorkationServiceIntegrationTest {

    @Autowired
    private WorkationServiceImpl workationService;

    @Autowired
    private WorkationRepository workationRepository;

    @Test
    public void testImportCSV_shouldImportWorkationsCorrectly() {

        // When
       // workationService.importCSV();

        // Then
        List<Workation> workations = workationRepository.findAll();
        assertFalse(workations.isEmpty());
        assertNotNull(workations.get(0).getEmployee());
        assertNotNull(workations.get(0).getRisk());
    }

    @Test
    public void testGetWorkations_shouldReturnImportedData() {
        // Prepare database
        //workationService.importCSV();

        // When
        List<Workation> workations = workationService.getWorkations();

        // Then
        assertNotNull(workations);
        assertTrue(workations.size() > 0);
    }
}
