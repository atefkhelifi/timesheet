package tn.esprit.spring.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {

	@Autowired
	ContratRepository contratRepository;

	private static final Logger l = Logger.getLogger(ContratServiceImpl.class);

    //Logger logger = LoggerFactory.getLogger(this.getClass());
	public List<Contrat>  getAllContrats()


	 {
		l.info("In  retrieveAllContrats : "); 
		List<Contrat> contrats = (List<Contrat>)  contratRepository.findAll();  
		for (Contrat c : contrats) {
			l.debug("c +++ : " + c);
		}
		l.info("Out of retrieveAllContrats."); 
		return contrats;
	}
	
	public Contrat ajouterContrat(Contrat contrat) {
		l.info("ajout contrat : " +contrat);
		Contrat contratSaved=contratRepository.save(contrat);
		l.info("Out of  ajoutContrat. "); 
		return contratSaved; 
	}
	public void deleteContra(int id) {
		contratRepository.deleteById(id);;
	}

	

}