package com.example.patterns.factoryMethodCompleteFlow.persistance;

import com.example.patterns.factoryMethodCompleteFlow.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
