package com;

import com.springRest.Controller.DoctorController;
import com.springRest.enitity.Doctor;
import com.springRest.service.DiseaseService;
import com.springRest.service.DoctorService;
import com.springRest.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DoctorControllerTest {

    @Mock
    private DoctorService doctorService;

    @Mock
    private PatientService patientService;

    @Mock
    private DiseaseService diseaseService;

    @Mock
    private Model model;

    @InjectMocks
    private DoctorController doctorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListDoctors() {
        // Arrange
        List<Doctor> doctors = Arrays.asList(new Doctor(), new Doctor());
        when(doctorService.getAllDoctors()).thenReturn(doctors);

        // Act
        String viewName = doctorController.listDoctors(model);

        // Assert
        assertEquals("doctors/list-doctors", viewName);
        verify(model).addAttribute("doctors", doctors);
    }

    @Test
    void testSaveDoctor() {
        // Arrange
        Doctor doctor = new Doctor();

        // Act
        String viewName = doctorController.saveDoctor(doctor);

        // Assert
        assertEquals("redirect:/doctors/list", viewName);
        verify(doctorService).save(doctor);
    }
}