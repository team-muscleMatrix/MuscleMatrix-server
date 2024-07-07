package com.musclematrix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musclematrix.domain.Machine;

public interface MachineRepository extends JpaRepository<Machine, Long>{
	
}
