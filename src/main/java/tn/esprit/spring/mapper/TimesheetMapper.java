package tn.esprit.spring.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.dto.EmployeDTO;
import tn.esprit.spring.entities.Employe;

public class TimesheetMapper {
	@Autowired
    private ConfiguredModelMapper modelMapper;
	public Employe mapEmployeDtoToEmploye(EmployeDTO employedto) {
		Employe mappedEmploye = modelMapper.map(employedto , Employe.class);
		mappedEmploye.setActif(employedto.isActif());
		mappedEmploye.setContrat(employedto.getContrat());
		mappedEmploye.setDepartements(employedto.getDepartements());
		mappedEmploye.setEmail(employedto.getEmail());
		mappedEmploye.setNom(employedto.getNom());
		mappedEmploye.setPassword(employedto.getPassword());
		mappedEmploye.setPrenom(employedto.getPrenom());
		mappedEmploye.setRole(employedto.getRole());
		mappedEmploye.setTimesheets(employedto.getTimesheets());
			return mappedEmploye;
	}
	

}
