package com.prueba.msgestionviajes.repository;

import com.prueba.msgestionviajes.dto.ViajeDTO;
import com.prueba.msgestionviajes.model.Auto;
import com.prueba.msgestionviajes.model.Viaje;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ViajesRepository extends ReactiveMongoRepository<Viaje, Object> { }
