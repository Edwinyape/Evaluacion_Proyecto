package com.proyecto.proyecto.repository;

import com.proyecto.proyecto.model.entity.Solicitud;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SolicitudRepository extends MongoRepository<Solicitud, String> {
}
