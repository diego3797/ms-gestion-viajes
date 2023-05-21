package com.prueba.msgestionviajes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tracking {
    private Date date;
    private String pickup_address;
    private Location pickup_location;
}

