package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	private static final Logger l = Logger.getLogger(EntrepriseServiceImpl.class);
	 

	public Entreprise ajouterEntreprise(Entreprise entreprise) {
		l.info("In  addEntreprise : " + entreprise); 
		entrepriseRepoistory.save(entreprise);
		l.info("Out of  addEntreprise. "); 
		return entreprise;
	}
	
	public Departement ajouterDepartement(Departement dep) {
		l.info("In  addDepartement : " + dep); 
		deptRepoistory.save(dep);
		l.info("Out of  addDepartement. "); 
		return dep;
	}
	
	public List<Entreprise> retrieveAllEntreprises() {
		l.info("In  retrieveAllEntreprises : "); 
		List<Entreprise> entreprises =  (List<Entreprise>) entrepriseRepoistory.findAll();  
		for (Entreprise entreprise : entreprises) {
			l.debug("entreprise +++ : " + entreprise);
		}
		l.info("Out of retrieveAllEntreprises."); 
		return entreprises;
	}

	public Entreprise getEntrepriseById(int entrepriseId) {
		l.info("in  getEntreprise id = " + entrepriseId);

		Entreprise e=entrepriseRepoistory.findById(entrepriseId).get();
		l.info("entreprise returned : " + e);
		return e;
	}
	
	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		l.info("in  deleteEntreprise id = " + entrepriseId);
		Entreprise e =entrepriseRepoistory.findById(entrepriseId).get();	
		entrepriseRepoistory.delete(e);
		l.info("entreprise deleted." +e.getName() );
		l.info("out of  deleteentreprise"); 
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		l.info("in  deleteDepartement id = " + depId);

		Departement d=deptRepoistory.findById(depId).get();
		deptRepoistory.delete(d);
		
		l.info("departement deleted." +d.getName() );
		l.info("out of  deleteDepartement");
	}

	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		l.info("In  getAllDepartementByEntreprise : entrepriseId" + entrepriseId); 
		
		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
		l.info("entreprise  : " + entrepriseManagedEntity);
		
		List<String> depNames = new ArrayList<>();
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
			l.info("departements of entreprise : " + entrepriseManagedEntity);
			depNames.add(dep.getName());
			l.debug("dep +++ : " + dep);
		}
		l.info("Out of getAllDepartementByEntreprise. " );
		return depNames;
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		l.info("In entrepriseId  : " + entrepriseId);
		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
		
		Departement depManagedEntity = deptRepoistory.findById(depId).get();
		l.info(" departementId "+ depId  ); 
		
		depManagedEntity.setEntreprise(entrepriseManagedEntity);
		deptRepoistory.save(depManagedEntity);
		
		l.info("departement  affecté"); 
		l.info("Out of affecterDepartementAEntreprise. " ); 
	}

}
