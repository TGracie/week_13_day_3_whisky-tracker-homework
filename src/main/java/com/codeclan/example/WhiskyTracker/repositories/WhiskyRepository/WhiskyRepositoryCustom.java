package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {

    List<Whisky> findAllWhiskyFromYear(int year);

    List<Whisky> findAllWhiskyByRegion(String region);

    List<Whisky> getWhiskyFromDistilleryByAge(Long id, int age);


}
