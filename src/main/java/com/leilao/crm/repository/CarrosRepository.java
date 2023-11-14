package com.leilao.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leilao.crm.model.Carros;


@Repository	
public interface CarrosRepository extends JpaRepository<Carros, Long> {
	

}