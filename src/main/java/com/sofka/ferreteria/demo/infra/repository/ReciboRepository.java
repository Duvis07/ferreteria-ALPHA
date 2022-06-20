package com.sofka.ferreteria.demo.infra.repository;


import com.sofka.ferreteria.demo.infra.data.ReciboData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReciboRepository extends ReactiveMongoRepository<ReciboData, String> {
}
