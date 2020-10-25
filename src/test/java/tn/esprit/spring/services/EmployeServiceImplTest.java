package tn.esprit.spring.services;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImplTest {
	@Autowired
	EmployeServiceImpl employeServiceImpl;
	

	// @Test
	// public void testGetAllEmployes() {
	// List<Employe> listEmploye = employeServiceImpl.getAllEmployes();
	// // if there are 5 users in DB :
	// assertEquals(5, listEmploye .size());
	// }
	@Test
	public void TestAjouterContrat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2020-10-25");
		Contrat contrat = new Contrat(d, "CDI", 100);
		int addcontrat = employeServiceImpl.ajouterContrat(contrat);
	
		assertEquals(1,addcontrat);
	}
}
