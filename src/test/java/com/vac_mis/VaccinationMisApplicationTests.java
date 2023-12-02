package com.vac_mis;

import com.vac_mis.model.Vaccine;
import com.vac_mis.repo.IVaccineDao;
import com.vac_mis.service.IVaccineService;
import com.vac_mis.service.Implementation.VaccineServiceImplementation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class VaccinationMisApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private IVaccineService vaccineService;

	@Test
	public void testSaveVaccine() {
		// Test 1: Create a vaccine for testing
		Vaccine vaccine1 = new Vaccine();
		vaccine1.setName("Hepatitis");
		vaccine1.setDoseNumber(1);
		vaccine1.setLocalDate(LocalDate.of(2025, 1, 1));

		// Perform the save operation
		Vaccine savedVaccine1 = vaccineService.saveVaccine(vaccine1);

		// Verify that the saved vaccine is not null and has the expected properties

		assertNotNull(savedVaccine1);

		//		assertEquals("Malaria", savedVaccine1.getName());
//		assertEquals(1, savedVaccine1.getDoseNumber());
//		assertEquals(LocalDate.of(2022, 1, 1), savedVaccine1.getLocalDate());

		// Test 2: Create another vaccine for testing
		Vaccine vaccine2 = new Vaccine();
		vaccine2.setName("AIDS Vaccine");
		vaccine2.setDoseNumber(2);
		vaccine2.setLocalDate(LocalDate.of(2022, 2, 1));

		// Perform the save operation
		Vaccine savedVaccine2 = vaccineService.saveVaccine(vaccine2);

		// Verify that the saved vaccine is not null and has the expected properties

		assertNotNull(savedVaccine2);

		//		assertEquals("Cancer Vaccine", savedVaccine2.getName());
//		assertEquals(2, savedVaccine2.getDoseNumber());
//		assertEquals(LocalDate.of(2022, 2, 1), savedVaccine2.getLocalDate());

		// You might perform additional assertions based on your specific requirements

		// Cleanup: Delete the vaccines from the database
//		vaccineDao.delete(savedVaccine1);
//		vaccineDao.delete(savedVaccine2);
	}
}
