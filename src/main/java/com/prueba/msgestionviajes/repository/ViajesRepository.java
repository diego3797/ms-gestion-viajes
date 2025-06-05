package com.prueba.msgestionviajes.repository;

import com.prueba.msgestionviajes.model.Viaje;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViajesRepository extends ReactiveMongoRepository<Viaje, Object> { }
