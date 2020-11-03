package tn.esprit.spring.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.dto.ContratDTO;
import tn.esprit.spring.dto.EmployeDTO;
import tn.esprit.spring.dto.MissionDTO;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;

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
	public Mission mapMissionDtoToMission(MissionDTO missiondto) {
		Mission mappedMission = modelMapper.map(missiondto, Mission.class);
		mappedMission.setDepartement(missiondto.getDepartement());
		mappedMission.setDescription(missiondto.getDescription());
		mappedMission.setName(missiondto.getName());
		mappedMission.setTimesheets(missiondto.getTimesheets());
			return mappedMission;
	}
	public Contrat mapContratDtoToContrat(ContratDTO contratdto) {
		Contrat mappedContrat = modelMapper.map(contratdto, Contrat.class);
		mappedContrat.setDateDebut(contratdto.getDateDebut());
		mappedContrat.setEmploye(contratdto.getEmploye());
		mappedContrat.setSalaire(contratdto.getSalaire());
	
		mappedContrat.setTypeContrat(contratdto.getTypeContrat());
			return mappedContrat;
	}
	
	

}