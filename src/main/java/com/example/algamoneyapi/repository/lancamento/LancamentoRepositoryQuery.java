package com.example.algamoneyapi.repository.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.algamoneyapi.model.Lancamento;
import com.example.algamoneyapi.repository.filter.LancamentoFilter;

/*
 * Precisa ter esse nome inicial LancamentoRepository
 */
public interface LancamentoRepositoryQuery {
	
	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);

}
