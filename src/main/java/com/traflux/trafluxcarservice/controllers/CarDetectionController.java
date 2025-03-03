package com.traflux.trafluxcarservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.traflux.trafluxcarservice.entities.CarDetectionModel;
import com.traflux.trafluxcarservice.services.CarDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/car")
public class CarDetectionController {

    private final CarDetectionService carDetectionService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    public CarDetectionController(CarDetectionService carDetectionService) {
        this.carDetectionService = carDetectionService;
    }

    @GetMapping(value = "/getcars", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CarDetectionModel>> getAllDetectedCars() {
        List<CarDetectionModel> detections = carDetectionService.getAllDetectedCars();
        return ResponseEntity.status(HttpStatus.OK).body(detections);
    }

    @GetMapping("/getmostrecentcar")
    public ResponseEntity<CarDetectionModel> getMostRecentDetectedCar() {
        CarDetectionModel mostRecentDetectedCar = carDetectionService.getMostRecentDetectedCar();
        return ResponseEntity.status(HttpStatus.OK).body(mostRecentDetectedCar);
    }

}
