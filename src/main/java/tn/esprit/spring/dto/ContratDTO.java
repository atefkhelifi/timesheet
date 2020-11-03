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


	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	
}