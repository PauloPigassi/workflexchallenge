package com.example.workflex.controller;

import com.example.workflex.model.Workation;
import com.example.workflex.service.impl.WorkationServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class WorkationControllerTest {

    @Mock
    private WorkationServiceImpl workationService;

    @InjectMocks
    private WorkationController controller;

    private MockMvc mockMvc;

    public WorkationControllerTest() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testGetWorkations_whenDataIsPresent_shouldReturnWorkationList() throws Exception {
        Workation mockWorkation = Workation.builder()
                .workationId("W1")
                .employee("John Doe")
                .origin("Germany")
                .destination("USA")
                .startDate(LocalDate.of(2024, 1, 1))
                .endDate(LocalDate.of(2024, 1, 10))
                .workingDays(10)
                .risk("NO_RISK")
                .build();

        when(workationService.count()).thenReturn(1L);
        when(workationService.getWorkations()).thenReturn(List.of(mockWorkation));

        mockMvc.perform(get("/workflex/workation"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].employee").value("John Doe"))
                .andExpect(jsonPath("$[0].risk").value("NO_RISK"));

        verify(workationService, never()).importCSV();
    }

    @Test
    public void testGetWorkations_whenEmpty_shouldCallImportCSV() throws Exception {
        when(workationService.count()).thenReturn(0L);
        when(workationService.getWorkations()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/workflex/workation"))
                .andExpect(status().isOk());

        verify(workationService, times(1)).importCSV();
    }
}