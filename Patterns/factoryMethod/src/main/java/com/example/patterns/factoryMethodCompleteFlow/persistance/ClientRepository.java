package com.example.patterns.factoryMethodCompleteFlow.persistance;

import com.example.patterns.factoryMethodCompleteFlow.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
