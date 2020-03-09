package com.stefanini.servico;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.PessoaDao;
import com.stefanini.model.Pessoa;
import com.stefanini.util.IGenericService;

/**
 * Classe que contém regras de negócio para a Pessoa
 */
public class PessoaServico implements IGenericService<Pessoa, Long>{

	@Inject
	private PessoaDao pessoaDao;

	/**
	 * Salvar os dados de uma pessoa
	 */
	@Override
	public Pessoa salvar(@Valid Pessoa pessoa) {
		return pessoaDao.salvar(pessoa);
	}

	/**
	 * Atualizar os dados de uma pessoa
	 */
	@Override
	public Pessoa atualizar(@Valid Pessoa entity) {
		// TODO Auto-generated method stub
		return pessoaDao.atualizar(entity);
	}

	/**
	 * Remover uma pessoa pelo id
	 */
	@Override
	public void remover(Long id) {
		pessoaDao.remover(id);

	}

	/**
	 * Buscar uma lista de Pessoa
	 */
	@Override
	public Optional<List<Pessoa>> getList() {
		// TODO Auto-generated method stub
		return pessoaDao.getList();
	}

	/**
	 * Buscar uma Pessoa pelo ID
	 */
	@Override
	public Optional<Pessoa> encontrar(Long id) {
		// TODO Auto-generated method stub
		return pessoaDao.encontrar(id);
	}

}
