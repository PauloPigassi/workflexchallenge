package com.example.workflex.repository;

import com.example.workflex.model.Workation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkationRepository extends JpaRepository<Workation, Long> {
}

