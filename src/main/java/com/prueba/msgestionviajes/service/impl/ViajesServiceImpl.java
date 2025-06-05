package com.prueba.msgestionviajes.service.impl;

import com.prueba.msgestionviajes.dto.DatosDTO;
import com.prueba.msgestionviajes.dto.ViajeDTO;
import com.prueba.msgestionviajes.model.Viaje;
import com.prueba.msgestionviajes.repository.ViajesRepository;
import com.prueba.msgestionviajes.service.ViajesService;
import com.prueba.msgestionviajes.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class ViajesServiceImpl implements ViajesService {

    @Autowired
    private ViajesRepository repositorio;

    public Mono<DatosDTO> getTotalViajes(){
        return repositorio.findAll()
                        .count()
                        .map(count -> new DatosDTO(String.valueOf(count)));
    }

    public Mono<DatosDTO> getCantViajesByCiudad(String ciudad){
        return repositorio.findAll()
                        .map(Utils::entidadToDto)
                        .filter(v -> ciudad.equals(v.getCity().getName()))
                        .count()
                        .map(count -> new DatosDTO(String.valueOf(count)));
    }

    public Mono<DatosDTO> getCantViajesByPais(String pais){
        return  repositorio.findAll()
                        .filter(v -> pais.equals(v.getCountry().getName()))
                        .count()
                        .map(count -> new DatosDTO(String.valueOf(count)));
    }

    public Mono<ViajeDTO> crearViaje(ViajeDTO viajeDTOMono){

        Viaje newViaje = new Viaje();
        newViaje.setStart(viajeDTOMono.getStart());
        newViaje.setEnd(viajeDTOMono.getEnd());
        newViaje.setCountry(viajeDTOMono.getCountry());
        newViaje.setCity(viajeDTOMono.getCity());
        newViaje.setPassenger(viajeDTOMono.getPassenger());
        newViaje.setDriver(viajeDTOMono.getDriver());
        newViaje.setCar(viajeDTOMono.getCar());
        newViaje.setStatus(viajeDTOMono.getStatus());
        newViaje.setCreatedAt(new Date());
        newViaje.setPrice(viajeDTOMono.getPrice());
        newViaje.setDriver_location(viajeDTOMono.getDriver_location());

        return repositorio.insert(newViaje).map(Utils::entidadToDto);
    }

    public Mono<ViajeDTO> actualizarViaje(String id, ViajeDTO viajeDTOMono){

        return repositorio.findById(id).flatMap(t->{

            t.setStart(viajeDTOMono.getStart());
            t.setEnd(viajeDTOMono.getEnd());
            t.setCountry(viajeDTOMono.getCountry());
            t.setCity(viajeDTOMono.getCity());
            t.setPassenger(viajeDTOMono.getPassenger());
            t.setDriver(viajeDTOMono.getDriver());
            t.setCar(viajeDTOMono.getCar());
            t.setStatus(viajeDTOMono.getStatus());
            t.setCreatedAt(viajeDTOMono.getCreatedAt());
            t.setUpdatedAt(new Date());
            t.setPrice(viajeDTOMono.getPrice());
            t.setDriver_location(viajeDTOMono.getDriver_location());


            return repositorio.save(t).map(Utils::entidadToDto);
        });

    }

    @Override
    public Mono<Void> eliminarViaje(String id) {
        return repositorio.deleteById(id);
    }

    public Flux<Viaje> getViajesActuales(){
        return repositorio.findAll().filter(v -> "started".equals(v.getStatus()));
    }
}
