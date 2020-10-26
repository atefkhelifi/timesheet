package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.services.ContratServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceImplTest {
	@Autowired
	ContratServiceImpl contratServiceimpl;
   @Autowired
   ContratRepository contratrep;
	/*@Test
	public void testRetrieveAllContrats() {
		List<Contrat> contrats=contratServiceimpl.getAllContrats();
	assertEquals(1, contrats.size());
	
	}*/
	/*@Test
	public void testAjoutContrat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d= dateFormat.parse("2015-03-23");
		Contrat contrat = new Contrat(d, "xx", 1100); 
		Contrat contratAdded = contratServiceimpl.ajouterContrat(contrat);
		assertNotNull(contratAdded);
	}*/
	
	 @Test
	 public void testdeleteContratById() {
		  
	
		contratServiceimpl.deleteContra(1);
		Contrat c =contratrep.findById(1).get();
		  assertEquals(1, c.getReference()); 
	
}
}