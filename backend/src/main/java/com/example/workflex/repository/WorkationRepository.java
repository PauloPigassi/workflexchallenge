package com.example.workflex.repository;

import com.example.workflex.model.entities.Workation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkationRepository extends JpaRepository<Workation, Long> {
}

