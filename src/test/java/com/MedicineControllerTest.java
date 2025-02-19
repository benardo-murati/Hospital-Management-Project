package com;

import com.springRest.Controller.MedicineController;
import com.springRest.enitity.Medicine;
import com.springRest.service.MedicineService;
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

class MedicineControllerTest {

    @Mock
    private MedicineService medicineService;

    @Mock
    private Model model;

    @InjectMocks
    private MedicineController medicineController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListMedicines() {
        // Arrange
        List<Medicine> medicines = Arrays.asList(new Medicine(), new Medicine());
        when(medicineService.getAllmedicines()).thenReturn(medicines);

        // Act
        String viewName = medicineController.listmedicines(model);

        // Assert
        assertEquals("medicine/list-medicines", viewName);
        verify(model).addAttribute("medicines", medicines);
    }

    @Test
    void testSaveMedicine() {
        // Arrange
        Medicine medicine = new Medicine();

        // Act
        String viewName = medicineController.savemedicine(medicine);

        // Assert
        assertEquals("redirect:/medicines/list", viewName);
        verify(medicineService).save(medicine);
    }

}
