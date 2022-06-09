package com.proyecto.proyecto.repository;

import com.proyecto.proyecto.model.entity.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
