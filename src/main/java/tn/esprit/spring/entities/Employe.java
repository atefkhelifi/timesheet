package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Employe implements Serializable {
	
	private static final long serialVersionUID = -1396669830860400871L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String prenom;
	private String nom;
	private String email;
	private String password;
	private boolean actif;
	@Enumerated(EnumType.STRING)
	private Role role;
	@JsonIgnore
	@ManyToMany(mappedBy="employes",fetch=FetchType.EAGER )
	private List<Departement> departements;
	@JsonIgnore
	@OneToOne(mappedBy="employe")
	private Contrat contrat;
	@JsonIgnore
	@OneToMany(mappedBy="employe")
	private List<Timesheet> timesheets;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Departement> getDepartements() {
		return departements;
	}
	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
	public Contrat getContrat() {
		return contrat;
	}
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
	public List<Timesheet> getTimesheets() {
		return timesheets;
	}
	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Employe(int id, String prenom, String nom, String email, String password, boolean actif, Role role,
			List<Departement> departements, Contrat contrat, List<Timesheet> timesheets) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.actif = actif;
		this.role = role;
		this.departements = departements;
		this.contrat = contrat;
		this.timesheets = timesheets;
	}
	@Override
	public String toString() {
		return "Employe [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", password="
				+ password + ", actif=" + actif + ", role=" + role + ", departements=" + departements + ", contrat="
				+ contrat + ", timesheets=" + timesheets + "]";
	}
	public Employe() {
		super();
	}
	public Employe(String prenom, String nom, String email, String password, boolean actif, Role role,
			List<Departement> departements, Contrat contrat, List<Timesheet> timesheets) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.actif = actif;
		this.role = role;
		this.departements = departements;
		this.contrat = contrat;
		this.timesheets = timesheets;
	}
	public Employe(String prenom, String nom, String email, String password, boolean actif, Role role) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.actif = actif;
		this.role = role;
	}

	
	
	
}
