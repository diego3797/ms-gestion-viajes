package com.prueba.msgestionviajes.controller;

import com.prueba.msgestionviajes.dto.DatosDTO;
import com.prueba.msgestionviajes.dto.ViajeDTO;
import com.prueba.msgestionviajes.model.Viaje;
import com.prueba.msgestionviajes.service.ViajesService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/viajes")
public class ViajeController {

    @Autowired
    private ViajesService service;

    @Operation(summary = "", description = "consulta la cantidad total de viajes")
    @GetMapping
    public Mono<DatosDTO> consultarTotal() {
        return service.getTotalViajes();
    }

    @Operation(summary = "/ciudad/{ciudad}", description = "consulta la cantidad total de viajes por ciudad")
    @GetMapping("/ciudad/{ciudad}")
    public Mono<DatosDTO> consultarViajesByCiudad(@PathVariable("ciudad") String ciudad) {
        return service.getCantViajesByCiudad(ciudad);
    }

    @Operation(summary = "/pais/{pais}", description = "consulta la cantidad total de viajes por pais")
    @GetMapping("/pais/{pais}")
    public Mono<DatosDTO> consultarViajesByPais(@PathVariable("pais") String pais) {
        return service.getCantViajesByPais(pais);
    }

    @Operation(summary = "", description = "crear viaje")
    @PostMapping
    public Mono<ViajeDTO> crear(@RequestBody ViajeDTO viaje) {
        return service.crearViaje(viaje);
    }

    @Operation(summary = "/{id}", description = "actualizar viaje")
    @PutMapping("/{id}")
    public Mono<ViajeDTO> actualizar(@RequestBody ViajeDTO viaje, @PathVariable String id) {
        return service.actualizarViaje(id, viaje);
    }

    @Operation(summary = "/{id}", description = "eliminar viaje")
    @DeleteMapping("/{id}")
    public Mono<Void> eliminar(@PathVariable String id) {
        return service.eliminarViaje(id);
    }

    @Operation(summary = "/actuales", description = "consulta viajes actuales (estado = started)")
    @GetMapping("/actuales")
    public Flux<Viaje> consultarViajesActuales() {
        return service.getViajesActuales();
    }

}
