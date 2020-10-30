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

	// Logger logger = LoggerFactory.getLogger(this.getClass());
	public List<Contrat> getAllContrats()

	{
		l.info("In  retrieveAllContrats : ");
		List<Contrat> contrats = (List<Contrat>) contratRepository.findAll();
		for (Contrat c : contrats) {
			l.debug("c +++ : " + c);
		}
		l.info("Out of retrieveAllContrats.");
		return contrats;
	}

	public Contrat ajouterContrat(Contrat contrat) {
		l.info("ajout contrat : " + contrat);
		Contrat contratSaved = contratRepository.save(contrat);
		l.info("Out of  ajoutContrat. ");
		return contratSaved;
	}

	public Contrat updateContrat(Contrat c) {
		l.info("ajout contrat : " + c);
		Contrat contratSaved = contratRepository.save(c);
		l.info("Out of  ajoutContrat. ");
		return contratSaved;
	}
	/*
	 * public Contrat retrieveContrat(int id) { l.info("in  retrieveContrat id = " +
	 * id); // Optional retrun type - Java 8 (susceptible de retourner des valeurs
	 * «vides» et pas null) Contrat c = contratRepository.findById(id).orElse(null);
	 * //User u = userRepository.findById(Long.parseLong(id)).get();
	  l.info("Contrat   returned : " + c); return c; }
	 

	/*
	 * public Contrat updateContrat(int id) { Contrat contrat = new Contrat();
	 * contratRepository.findById(id);
	 * 
	 * return (Contrat)contratRepository.save(contrat); }
	 */

}