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
	public void deleteDepartement(int depId) {
		l.info("in  deleteDepartement id = " + depId);

		Departement d=deptRepoistory.findById(depId).get();
		deptRepoistory.delete(d);
		
		l.info("departement deleted." +d.getName() );
		l.info("out of  deleteDepartement");
	}

	public Departement addDepartement(Departement u) {
		l.info("In  addDepartement : " + u); 
		Departement depSaved = deptRepoistory.save(u);
		l.info("Out of  addDepartement. "); 
		return depSaved; 
	}
	
	public Departement updateDepartement(Departement u) {
		l.info("In  updateDepartement : " + u); 
		Departement depSaved = deptRepoistory.save(u);
		l.info("Out of  updateDepartement. "); 
		return depSaved; 
	}
	
	public Departement retrieveDepartement(int id) {
		l.info("in  retrieveDepartement id = " + id);
		Departement u =  deptRepoistory.findById(id).get();
		l.info("user returned : " + u);
		return u; 
	}
	
}
