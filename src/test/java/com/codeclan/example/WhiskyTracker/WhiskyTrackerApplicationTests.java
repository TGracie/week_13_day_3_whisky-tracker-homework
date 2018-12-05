package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

    @Autowired
    DistilleryRepository distilleryRepository;

    @Autowired
    WhiskyRepository whiskyRepository;

	@Test
	public void contextLoads() {
	}

	@Test
    public void getWhiskyByYear2018(){
        List<Whisky> results = whiskyRepository.findAllWhiskyFromYear(2018);
    }

    @Test
    public void getWhiskyByRegionHighland(){
	    List<Whisky> results = whiskyRepository.findAllWhiskyByRegion("Highland");
    }

    @Test
    public void getDistilleriesByRegionHighland(){
	    List<Distillery> results = distilleryRepository.findAllDistilleriesByRegion("Highland");
    }

    @Test
    public void getWhiskyByAge12FromDistillery(){
	    List<Whisky> results = whiskyRepository.getWhiskyFromDistilleryByAge(1L, 12);
    }

    @Test
    public void getDistilleriesWithWhiskyOverAge(){
	    List<Distillery> results = distilleryRepository.findAllDistilleryWithWhiskyOverAge(12);
    }

    // pass in a distillery
    // pass in an age

    // for each whisky in whiskies in distillery
    //return list of whisky where whisky.age = age

}
