package com.traflux.trafluxcarservice.repositories;

import com.traflux.trafluxcarservice.entities.CarDetectionModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

public interface CarDetectionRepository extends MongoRepository<CarDetectionModel, String> {
    CarDetectionModel findTopByOrderByTimestampDesc();
}
