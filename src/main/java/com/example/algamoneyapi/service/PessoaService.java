package com.example.algamoneyapi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.algamoneyapi.model.Pessoa;
import com.example.algamoneyapi.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public Pessoa atualizarPessoa(Long codigo, Pessoa pessoa) {
		Pessoa salvo = buscarPessoaPeloCodigo(codigo);
		BeanUtils.copyProperties(pessoa, salvo, "codigo");
		return repository.save(salvo);
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
		pessoaSalva.setAtivo(ativo);
		repository.save(pessoaSalva);
	}

	public Pessoa buscarPessoaPeloCodigo(Long codigo) {
		Optional<Pessoa> salvoOp = repository.findById(codigo);
		if (salvoOp.isPresent()) {
			return salvoOp.get();
		}
		throw new EmptyResultDataAccessException(1);
	}

}
