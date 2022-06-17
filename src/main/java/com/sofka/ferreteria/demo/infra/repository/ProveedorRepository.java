package com.sofka.ferreteria.demo.infra.repository;

import com.sofka.ferreteria.demo.infra.data.ProveedorData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends ReactiveMongoRepository<ProveedorData, String> {
}
