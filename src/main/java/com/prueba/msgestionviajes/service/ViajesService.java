package com.prueba.msgestionviajes.service;

import com.prueba.msgestionviajes.dto.DatosDTO;
import com.prueba.msgestionviajes.dto.ViajeDTO;
import com.prueba.msgestionviajes.model.Viaje;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ViajesService {

    Mono<DatosDTO> getTotalViajes();

    Mono<DatosDTO> getCantViajesByCiudad(String ciudad);

    Mono<DatosDTO> getCantViajesByPais(String pais);

    Mono<ViajeDTO> crearViaje(ViajeDTO viajeDTOMono);

    Mono<ViajeDTO> actualizarViaje(String id, ViajeDTO viajeDTOMono);

    Mono<Void> eliminarViaje(String id);

    Flux<Viaje> getViajesActuales();
}
