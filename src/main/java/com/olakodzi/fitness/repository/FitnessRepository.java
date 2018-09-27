package com.olakodzi.fitness.repository;

import com.olakodzi.fitness.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessRepository extends JpaRepository<Client,Long> {
}
