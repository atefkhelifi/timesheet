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
	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	ContratRepository contratRepoistory;
//	 @Test
//	 public void TestEmployeAuthenticate() {
//	Employe authenticateEmploye =
//	 employeServiceImpl.authenticate("khaoula.mejri.1@esprit.tn", "khaoula");
//	 assertEquals(1, authenticateEmploye.getId());
//	 }

	/***************************************************/
//	 @Test
//	 public void TestAddOrUpdateEmploye() {
//	 Employe employe=new Employe("loutcha", "loutch",
//	 "khaoula.mejri.1@esprit.tn", "loutcha", true, null);
//	 int idEmploye = employeServiceImpl.addOrUpdateEmploye(employe);
//	
//	 assertEquals(3,idEmploye);
//	 }
	/*************************************************/

	 @Test
	 public void TestmettreAjourEmailByEmployeId() {
	 employeServiceImpl.mettreAjourEmailByEmployeId("khaoulaaaaa.mejri.1@esprit.tn",
	 1);
	 Employe employe = employeRepository.findById(1).get();
	
	 assertEquals("khaoulaaaaa.mejri.1@esprit.tn", employe.getEmail());
	
	 }
	/********************************************/
//	 @Test
//		 public void testAffecterEmployeADepartement() {
//		
//		 employeServiceImpl.affecterContratAEmploye(1, 1);
//		 Departement departement= deptRepoistory.findById(1).get();
//		 int nbrEmployeParDepartement = departement.getEmployes().size();
//		 assertEquals(1, nbrEmployeParDepartement);
//		
//		 }

	/*******************************************/
//	 @Test 
//	 public void desaffecterEmployeDuDepartementTest() {
//		 employeServiceImpl.desaffecterEmployeDuDepartement(1, 1);
//		Departement departement= deptRepoistory.findById(1).get(); 
//		int nbrEmployeParDepartement = departement.getEmployes().size();
//		 assertEquals(1, nbrEmployeParDepartement);}
		 /**********************/
//	 @Test
//		 public void TestAjouterContrat() throws ParseException {
//		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		 Date d = dateFormat.parse("2020-10-25");
//		 Contrat contrat = new Contrat(d, "CDI", 250);
//		 int idcontrat = employeServiceImpl.ajouterContrat(contrat);
//		
//		 assertEquals(3,idcontrat);
//		 }
	/***************************************/

	// @Test
	// public void testGetAllEmployes() {
	// List<Employe> listEmploye = employeServiceImpl.getAllEmployes();
	// // if there are 5 users in DB :
	// assertEquals(5, listEmploye .size());
	// }

}
