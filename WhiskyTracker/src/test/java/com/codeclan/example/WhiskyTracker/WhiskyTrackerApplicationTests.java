package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyByYear(){
		List<Whisky> foundWhisky = whiskyRepository.findWhiskyByYear(1995);
		assertEquals(1, foundWhisky.size());
	}

	@Test
	public void canFindDistilleryByRegion() {
		List<Distillery> foundDistillery = distilleryRepository.findDistilleryByRegion("Speyside");
		assertEquals(3, foundDistillery.size());
	}

	@Test
	public void canFindWhiskyByAgeAndDistillery() {
		List<Whisky> foundWhisky = whiskyRepository.findWhiskyByAgeAndDistilleryName(15, "Glendronach");
		assertEquals(1, foundWhisky.size());
		assertEquals("The Glendronach Revival", foundWhisky.get(0).getName());
	}

	@Test
	public void canFindWhiskyByRegion() {
		List<Whisky> foundWhisky = whiskyRepository.findWhiskyByDistilleryRegion("Island");
		assertEquals(6, foundWhisky.size());
	}


	@Test
	public void canFindDistilleriesWithWhiskies12() {
		List<Distillery> foundDistillery = distilleryRepository.findDistilleryByWhiskiesAge(12);
		assertEquals(6, foundDistillery.size());
	}




}
