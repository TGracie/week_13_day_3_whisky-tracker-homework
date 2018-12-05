package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface DistilleryRepositoryCustom {

    List<Distillery> findAllDistilleriesByRegion(String region);

    List<Whisky> getWhiskyFromDistilleryByAge(Distillery dist, int age);

    List<Distillery> findAllDistilleryWithWhiskyOverAge(int age);

}
