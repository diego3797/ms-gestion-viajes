package com.prueba.msgestionviajes.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.prueba.msgestionviajes.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViajeDTO {
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
    private Date createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date updatedAt;
    private Location driver_location;
}
