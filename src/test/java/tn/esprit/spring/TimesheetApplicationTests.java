package tn.esprit.spring;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.DepartementServiceImpl;
import tn.esprit.spring.services.EntrepriseServiceImpl;

@SpringBootTest
class TimesheetApplicationTests {

	@Autowired
	EntrepriseServiceImpl entrepriseServiceImpl;
	
	@Autowired
	DepartementServiceImpl departementServiceImpl;
	
	
	
	/*@Test
	public void TestAjouterEntreprise() throws ParseException {
		Entreprise u = new Entreprise("Focus", "marketing"); 
		Entreprise entrepriseAdded = entrepriseServiceImpl.ajouterEntreprise(u); 
		assertEquals(u.getName(), entrepriseAdded.getRaisonSocial());
	}*/
	
	/*
	@Test
	public void testgetEntrepriseById() {
		Entreprise EntrepriseByIdRetrieved = entrepriseServiceImpl.getEntrepriseById(1); 
		assertEquals(1L, EntrepriseByIdRetrieved.getId());
	}
	*/
	
/*	@Test
	public void testgetAllDepartementsNamesByEntreprise(int entrepriseId) {
		Entreprise EntrepriseByIdRetrieved = entrepriseServiceImpl.getEntrepriseById(1); 
		assertEquals(1L, EntrepriseByIdRetrieved.getId());
	}
	*/

}
