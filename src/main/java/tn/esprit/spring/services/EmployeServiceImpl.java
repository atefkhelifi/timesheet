package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	ContratRepository contratRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;
	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);

	@Override
	public Employe authenticate(String login, String password) {
		l.info("Authentication");
		return employeRepository.getEmployeByEmailAndPassword(login, password);
	}

	@Override
	public int addOrUpdateEmploye(Employe employe) {
		l.info("In  addOrUpdateEmploye : " + employe);
		employeRepository.save(employe);
		l.info("Out of  addOrUpdateEmploye. ");
		return employe.getId();
	}

	public void mettreAjourEmailByEmployeId(String email, int employeId) {
		l.info("In  MettreAjourEmailByEmployeId : ");
		Employe employe = employeRepository.findById(employeId).get();
		employe.setEmail(email);
		employeRepository.save(employe);
		l.info("Out of  MettreAjourEmailByEmployeId. ");

	}

	@Transactional
	public void affecterEmployeADepartement(int employeId, int depId) {
		l.info("In  AffecterEmployeADepartement. ");
		l.info("In  FindDepartement : " + depId);
		Departement depManagedEntity = deptRepoistory.findById(depId).get();
		l.info("Out Of  FindDepartement : " + depId);
		l.info("In  FindEmploye : " + employeId);
		Employe employeManagedEntity = employeRepository.findById(employeId).get();
		l.info("Out Of FindEmploye : " + employeId);
		l.info(" if there are  no employees  ");
		if (depManagedEntity.getEmployes() == null) {
			List<Employe> employes = new ArrayList<>();
			employes.add(employeManagedEntity);
			depManagedEntity.setEmployes(employes);
		} else {
			l.info(" if there are employees ");
			depManagedEntity.getEmployes().add(employeManagedEntity);
		}
		// à ajouter?
		deptRepoistory.save(depManagedEntity);
		l.info("Out of  AffecterEmployeADepartement. ");

	}

	@Transactional
	public void desaffecterEmployeDuDepartement(int employeId, int depId)
	{
		Departement dep = deptRepoistory.findById(depId).get();

		int employeNb = dep.getEmployes().size();
		for(int index = 0; index < employeNb; index++){
			if(dep.getEmployes().get(index).getId() == employeId){
				dep.getEmployes().remove(index);
				break;//a revoir
			}
		}
	} 
	
	// Tablesapce (espace disque) 

	public int ajouterContrat(Contrat contrat) {
		l.info("In  addContrat : " + contrat); 
		contratRepoistory.save(contrat);
		l.info("Out of  addContat. "); 
		return contrat.getReference();
	}

	public void affecterContratAEmploye(int contratId, int employeId) {
		Contrat contratManagedEntity = contratRepoistory.findById(contratId).get();
		Employe employeManagedEntity = employeRepository.findById(employeId).get();
		l.info("In  FindContrat : " + contratId); 
		l.info("In  FindEmploye : " + employeId); 
		contratManagedEntity.setEmploye(employeManagedEntity);
		contratRepoistory.save(contratManagedEntity);
		l.info("Out of  ContratEmploye. "); 

	}

	public String getEmployePrenomById(int employeId) {
		l.info("In  GetEmployePrenomById= " + employeId);
		Employe employeManagedEntity = employeRepository.findById(employeId).get();
		return employeManagedEntity.getPrenom();
	}
	public void deleteEmployeById(int employeId) {
		l.info("In  DeleteEmployeById= " + employeId);
		Employe employe = employeRepository.findById(employeId).get();

		// Desaffecter l'employe de tous les departements
		// c'est le bout master qui permet de mettre a jour
		// la table d'association
		for (Departement dep : employe.getDepartements()) {
			dep.getEmployes().remove(employe);
		}

		employeRepository.delete(employe);
		l.info("out of DeleteEmployeById");
	}

	public void deleteContratById(int contratId) {
		l.info("In  DeleteContratById = " + contratId);
		Contrat contratManagedEntity = contratRepoistory.findById(contratId).get();
		contratRepoistory.delete(contratManagedEntity);
		l.info("entreprise deleted." + contratManagedEntity.getReference());
		l.info("out of DeleteContratById");

	}
	public int getNombreEmployeJPQL() {
		l.info("Count the number of employees");
		return employeRepository.countemp();
	}

	public List<String> getAllEmployeNamesJPQL() {
		l.info("In  getAllEmployeNamesJPQL:");
		List<String> s=employeRepository.employeNames();
		l.info("Out of getAllEmployeNamesJPQL.");
		return s;

	}

	public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise) {
		l.info("In  getAllEmployeByEntreprise="+entreprise);
		List<Employe> employe=employeRepository.getAllEmployeByEntreprisec(entreprise);
		l.info("Out Of   getAllEmployeByEntreprise="+employe);
		return employe;
		
	}

	public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId) {
		l.info("In MettreAjourEmailByEmployeIdJPQL");
		employeRepository.mettreAjourEmailByEmployeIdJPQL(email, employeId);
		l.info("Out Of MettreAjourEmailByEmployeIdJPQL");

	}

	public void deleteAllContratJPQL() {
		l.info("In DeleteAllContratJPQL ");
		employeRepository.deleteAllContratJPQL();
		l.info("Out Of DeleteAllContratJPQL ");
	}

	public float getSalaireByEmployeIdJPQL(int employeId) {
		l.info("Display employee salary");
		return employeRepository.getSalaireByEmployeIdJPQL(employeId);
	}

	public Double getSalaireMoyenByDepartementId(int departementId) {
		l.info("Display the average salary by department");
		return employeRepository.getSalaireMoyenByDepartementId(departementId);
	}

	public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission, Date dateDebut,
			Date dateFin) {
		l.info("Display timesheetsBy mission and date");
		return timesheetRepository.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);
	}

	public List<Employe> getAllEmployes() {
		l.info("In  getAllEmployes : ");
		List<Employe> employes = (List<Employe>) employeRepository.findAll();
		for (Employe employe : employes) {
			l.debug("employe +++ : " + employe);
		}
		l.info("Out of retrieveAllUsers.");
		return employes;
	}


}
