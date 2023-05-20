package com.prueba.msgestionviajes.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Viajes")
public class Viaje {


    @JsonSerialize(using = ToStringSerializer.class)
    @Id
    private ObjectId id;
    private Tracking start;
    private Tracking end;
    private Ubigeo country;
    private Ubigeo city;
    private DatosPersona passenger;
    private DatosPersona driver;
    private Auto car;
    private String status;
    private String check_code;
    private int price;
    @CreatedDate
    private Date createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date updatedAt;
    private Location driver_location;




}
