package com.example.algamoneyapi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.algamoneyapi.model.Categoria;
import com.example.algamoneyapi.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria atualizarCategoria(Long codigo, Categoria categoria) {
		Optional<Categoria> salvoOp = repository.findById(codigo);
		if (salvoOp.isPresent()) {
			Categoria salva = salvoOp.get();
			BeanUtils.copyProperties(categoria, salva, "codigo");
			return repository.save(salva);
		}
		throw new EmptyResultDataAccessException(1);
	}

}
