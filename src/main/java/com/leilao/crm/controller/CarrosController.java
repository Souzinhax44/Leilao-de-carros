package com.leilao.crm.controller;

import java.math.BigDecimal;
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
            validarAno(carros.getAno());
            validarValor(carros.getValor());
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
            validarAno(carrosAtualizado.getAno());
            validarValor(carrosAtualizado.getValor());
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

    // Método de validação para o ano
    private void validarAno(int ano) {
        if (ano < 1807 || ano > 9999) {
            throw new IllegalArgumentException("Ano inválido. Deve ser entre 1807 e 9999.");
        }
    }

    // Método de validação para o valor
    private void validarValor(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor inválido. Deve ser acima de zero.");
        }
    }
}
