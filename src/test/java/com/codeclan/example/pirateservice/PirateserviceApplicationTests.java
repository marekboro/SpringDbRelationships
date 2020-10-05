package com.codeclan.example.pirateservice;

import com.codeclan.example.pirateservice.models.Pirate;
import com.codeclan.example.pirateservice.models.Raid;
import com.codeclan.example.pirateservice.models.Ship;
import com.codeclan.example.pirateservice.repositories.RaidRepository;
import com.codeclan.example.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.codeclan.example.pirateservice.repositories.PirateRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class PirateserviceApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void createPirate() {

		Ship ship1 = new Ship("Black Pearl");
		Ship ship2 = new Ship("BoatyMacBoatFace");
		Pirate pirate1 = new Pirate("Edward","Teach",70,ship2);
		Pirate pirate2 = new Pirate("Red","Beard",64,ship2);
		Pirate pirate3 = new Pirate("Jack","Sparrow",35,ship1);
		Pirate pirate4 = new Pirate("Davy","Jones",80,ship2);
		shipRepository.save(ship1);
		shipRepository.save(ship2);
		pirateRepository.save(pirate1);
		pirateRepository.save(pirate2);
		pirateRepository.save(pirate3);
		pirateRepository.save(pirate4);
		Raid raid1 = new Raid("Edinburgh",100);
		Raid raid2 = new Raid("London",90);
		Raid raid3 = new Raid("Glasgow",80);
		List<Pirate> list1 = new ArrayList<Pirate>();
		List<Pirate> list2 = new ArrayList<Pirate>();
		List<Pirate> list3 = new ArrayList<Pirate>();
		list1.add(pirate1);
		list1.add(pirate3);
		list1.add(pirate4);
		list2.add(pirate1);
		list2.add(pirate2);
		list3.add(pirate1);
		list3.add(pirate2);
		list3.add(pirate3);
		list3.add(pirate4);
		raid1.setPirates(list1);
		raid2.setPirates(list2);
		raid3.setPirates(list3);
		raidRepository.save(raid1);
		raidRepository.save(raid2);
		raidRepository.save(raid3);

	}
}
