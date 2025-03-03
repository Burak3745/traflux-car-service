package com.traflux.trafluxcarservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "detections")

@Data
public class CarDetectionModel {
    @Id
    @JsonFormat
    private String id;

    @Field("ust_detected_objects")
    @JsonFormat
    private int ust_detected_objects;

    @Field("alt_detected_objects")
    @JsonFormat
    private int alt_detected_objects;

    @Field("image")
    @JsonFormat
    private String image;

    @Field("timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date timestamp;

}