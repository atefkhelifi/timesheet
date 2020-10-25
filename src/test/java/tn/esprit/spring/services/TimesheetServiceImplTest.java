package tn.esprit.spring.services;

import static org.junit.Assert.assertEquals;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.MissionRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetServiceImplTest {
	@Autowired 
	ITimesheetService Tm; 
	@Autowired
	MissionRepository missionRepository;
	
	
	@Test
	public void testAjouterMission() {
	Mission mission = new Mission("test", "facile");
	int id=	Tm.ajouterMission(mission);
	//List<Mission> missions= (List<Mission>) missionRepository.findAll();
		
		assertEquals(1,id);
	}}


	/*
	List<Mission> missions= (List<Mission>) missionRepository.findAll();
	
	assertEquals(6,missions.size());

}
*/