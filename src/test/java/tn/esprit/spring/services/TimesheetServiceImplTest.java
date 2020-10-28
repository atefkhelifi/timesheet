package tn.esprit.spring.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetServiceImplTest {
	@Autowired 
	ITimesheetService Tm; 
	@Autowired
	MissionRepository missionRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;
	
/*	@Test
	public void testAjouterMission() {
	Mission mission = new Mission("test", "facile");
	int id=	Tm.ajouterMission(mission);
	//List<Mission> missions= (List<Mission>) missionRepository.findAll();
		
		assertEquals(4,id);
	}
*/
/*@Test
public void testAffecterMission() {

	
 Tm.affecterMissionADepartement(4,1);
 Mission mission =missionRepository.findById(4).get();
 int iddept=mission.getDepartement().getId();

 assertEquals(1,iddept);
	
	
	
}*/
	
	@Test
	public void testAjouterTimesheet() throws ParseException {

SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date db=dataFormat.parse("2020-10-23");
		Date df =dataFormat.parse("2020-10-25");
		
	 TimesheetPK timesheetPK = new TimesheetPK(5,1, db, df);
	Tm.ajouterTimesheet(5, 1, db, df);
	
	int idm=timesheetPK.getIdMission();
	
		assertEquals(5,idm);
	}

}


	/*
	List<Mission> missions= (List<Mission>) missionRepository.findAll();
	
	assertEquals(6,missions.size());

}
*/