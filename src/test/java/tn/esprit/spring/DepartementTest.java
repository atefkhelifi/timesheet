package tn.esprit.spring;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.DepartementServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementTest {

	@Autowired
	DepartementServiceImpl depService;
	
	@Test
	public void testRetrieveDepartement() {
		List<Departement> departements = depService.getAllDepartements(); 
		assertEquals(2, departements.size());
	}
}
