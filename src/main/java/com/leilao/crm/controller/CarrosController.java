package com.leilao.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.leilao.crm.model.Carros;
import com.leilao.crm.repository.CarrosRepository;

@RestController
@RequestMapping("/carros")
public class CarrosController {

    @Autowired
    private CarrosRepository carrosRepository;

    @GetMapping
    public List<Carros> listar() {
        try {
            return carrosRepository.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao buscar carros", e);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carros adicionar(@RequestBody Carros carros) {
        try {
            return carrosRepository.save(carros);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao adicionar carro", e);
        }
    }

    @GetMapping("/{id}")
    public Carros obterPorId(@PathVariable Long id) {
        try {
            return carrosRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado com o ID: " + id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao buscar carro por ID", e);
        }
    }

    @PutMapping("/{id}")
    public Carros atualizar(@PathVariable Long id, @RequestBody Carros carrosAtualizado) {
        try {
            return carrosRepository.findById(id).map(carro -> {
                carro.setModelo(carrosAtualizado.getModelo());
                carro.setAno(carrosAtualizado.getAno());
                carro.setValor(carrosAtualizado.getValor());
                carro.setEstado(carrosAtualizado.getEstado());
                return carrosRepository.save(carro);
            }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado com o ID: " + id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao atualizar carro", e);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        try {
            carrosRepository.findById(id).ifPresentOrElse(
                carrosRepository::delete,
                () -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado com o ID: " + id); }
            );
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao deletar carro", e);
        }
    }
}
