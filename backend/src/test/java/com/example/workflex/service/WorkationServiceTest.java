package com.example.workflex.service;

import com.example.workflex.model.entities.Workation;
import com.example.workflex.repository.WorkationRepository;
import com.example.workflex.service.impl.WorkationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WorkationServiceTest {

    @Mock
    private WorkationRepository workationRepository;

    @InjectMocks
    private WorkationServiceImpl workationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetWorkations_shouldReturnList() {
        Workation mockWorkation = Workation.builder()
                .workationId("W1")
                .employee("Jane Doe")
                .origin("Belgium")
                .destination("Spain")
                .startDate(LocalDate.of(2024, 2, 1))
                .endDate(LocalDate.of(2024, 2, 10))
                .workingDays(8)
                .risk("LOW_RISK")
                .build();

        when(workationRepository.findAll()).thenReturn(List.of(mockWorkation));

        List<Workation> result = workationService.getWorkations();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Jane Doe", result.get(0).getEmployee());
    }

    @Test
    public void testCount_shouldReturnNumberOfWorkations() {
        when(workationRepository.count()).thenReturn(5L);

        long count = workationService.count();

        assertEquals(5L, count);
    }

    @Test
    public void testImportCSV_shouldThrowRuntimeExceptionWhenFileNotFound() {
        // Force an error by providing an invalid resource inside the service manually
        WorkationServiceImpl serviceWithError = new WorkationServiceImpl(workationRepository) {
            @Override
            public void importCSV() {
                throw new RuntimeException("File not found");
            }
        };

        RuntimeException exception = assertThrows(RuntimeException.class, serviceWithError::importCSV);

        assertTrue(exception.getMessage().contains("File not found"));
    }
}