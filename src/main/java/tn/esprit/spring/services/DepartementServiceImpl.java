package tn.esprit.spring.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements IDepartementService {


	@Autowired
	DepartementRepository deptRepoistory;

	private static final Logger l = Logger.getLogger(DepartementServiceImpl.class);


	public List<Departement> getAllDepartements() {  
		l.info("In  retrieveAllDepartement() : "); 

		 List<Departement> departements= (List<Departement>) deptRepoistory.findAll();
		 for (Departement departement : departements) {
				l.debug("departement +++ : " + departement);
			}
			l.info("Out of retrieveAllDepartement.");
		 return departements;
	}

}
