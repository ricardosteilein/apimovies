package com.texoit.ricardo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.texoit.ricardo.entity.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Long> {
	
	Producer findByName(String name);
	
}
