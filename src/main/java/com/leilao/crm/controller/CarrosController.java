package com.leilao.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.leilao.crm.model.Carros;
import com.leilao.crm.repository.CarrosRepository;

@RestController
@RequestMapping("/carros")
public class CarrosController {
	
	@Autowired
	private CarrosRepository carrosRepository;
	
	@GetMapping
	public List<Carros> listar() {
		return carrosRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Carros adicionar(@RequestBody Carros carros) {
		return carrosRepository.save(carros);
	}
	
}
