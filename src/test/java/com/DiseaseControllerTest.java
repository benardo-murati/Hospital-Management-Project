package com;

import com.springRest.Controller.DiseaseController;
import com.springRest.enitity.Disease;
import com.springRest.service.DiseaseService;
import com.springRest.service.DoctorService;
import com.springRest.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DiseaseControllerTest {

    @Mock
    private DiseaseService diseaseService;

    @Mock
    private DoctorService doctorService;

    @Mock
    private PatientService patientService;

    @Mock
    private Model model;

    @InjectMocks
    private DiseaseController diseaseController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListDoctors() {
        List<Disease> diseases = Arrays.asList(new Disease(), new Disease());
        when(diseaseService.getAllDiseases()).thenReturn(diseases);

        String viewName = diseaseController.listDoctors(model);

        assertEquals("disease/list-disease", viewName);
        verify(model).addAttribute("diseaseList", diseases);
    }

    @Test
    public void testGetDoctorForm() {
        // Create a mock Disease object
        Disease mockDisease = new Disease();
        mockDisease.setId(0);
        mockDisease.setDiseaseName(null);

        // Call the method under test
        String viewName = diseaseController.getDoctorForm(model);

        // Verify the view name
        assertEquals("disease/addDisease", viewName);

        // Verify that the model attribute was added with the correct key and value
        verify(model).addAttribute(eq("disease"), eq(mockDisease));
    }

    @Test
    void testSaveDoctor() {
        Disease disease = new Disease();
        String viewName = diseaseController.saveDoctor(disease);

        assertEquals("redirect:/diseases/list", viewName);
        verify(diseaseService).save(disease);
    }

    @Test
    void testShowUpdateForm() {
        Disease disease = new Disease();
        when(diseaseService.findById(1)).thenReturn(disease);

        String viewName = diseaseController.showUpdateForm(1, model);

        assertEquals("disease/addDisease", viewName);
        verify(model).addAttribute("disease", disease);
    }


}