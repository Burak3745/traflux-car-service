package com.traflux.trafluxcarservice.services;

import com.traflux.trafluxcarservice.entities.CarDetectionModel;
import com.traflux.trafluxcarservice.repositories.CarDetectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CarDetectionService {

    private final CarDetectionRepository carDetectionRepository;

    @Autowired
    public CarDetectionService(CarDetectionRepository carDetectionRepository) {
        this.carDetectionRepository = carDetectionRepository;
    }

    public List<CarDetectionModel> getAllDetectedCars() {
        List<CarDetectionModel> detections = carDetectionRepository.findAll();
        return detections;
    }

    public CarDetectionModel getMostRecentDetectedCar() {
        return carDetectionRepository.findTopByOrderByTimestampDesc();
    }

}
