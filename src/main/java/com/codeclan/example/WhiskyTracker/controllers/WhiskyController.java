package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping
    public List<Whisky> getAllWhiskies(){
        return whiskyRepository.findAll();
    }

    @GetMapping(value = "/{year}")
    public List<Whisky> findAllWhiskyFromYear(@PathVariable int year){
        return whiskyRepository.findAllWhiskyFromYear(year);
    }

    @GetMapping(value = "/{region}")
    public List<Whisky> findAllWhiskyByRegion(@PathVariable String region){
        return whiskyRepository.findAllWhiskyByRegion(region);
    }

    @GetMapping(value = "/{distID}/{age}")
    public List<Whisky> getWhiskyFromDistilleryOfAge(@PathVariable Long id, int age){
        return whiskyRepository.getWhiskyFromDistilleryByAge(id, age);
    }

}
