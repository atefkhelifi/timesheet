package tn.esprit.spring.dto;

import java.util.Date;

import javax.persistence.OneToOne;

import tn.esprit.spring.entities.Employe;



public class ContratDTO{
	


	 int reference;
	
	 Date dateDebut;
	
	String typeContrat;
	
	
	float telephone;
	
	@OneToOne
	private Employe employe;

	float salaire;


	
	
}