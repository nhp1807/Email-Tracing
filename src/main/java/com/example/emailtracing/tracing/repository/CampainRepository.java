package com.example.emailtracing.tracing.repository;

import com.example.emailtracing.tracing.model.Campain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampainRepository extends JpaRepository<Campain, Integer> {
}
