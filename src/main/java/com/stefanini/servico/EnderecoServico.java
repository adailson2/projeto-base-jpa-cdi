package com.stefanini.servico;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.EnderecoDao;
import com.stefanini.model.Endereco;
import com.stefanini.util.IGenericService;

/**
 * Classe que contém regras de negócio para o Endereço
 */
public class EnderecoServico implements IGenericService<Endereco, Integer>{

	@Inject
	private EnderecoDao enderecoDao;

	/**
	 * Salvar os dados de um perfil
	 */
	@Override
	public Endereco salvar(@Valid Endereco endereco) {
		return enderecoDao.salvar(endereco);
	}

	/**
	 * Atualizar os dados de um perfil
	 */
	@Override
	public Endereco atualizar(@Valid Endereco entity) {
		// TODO Auto-generated method stub
		return enderecoDao.atualizar(entity);
	}

	/**
	 * Remover um perfil pelo id
	 */
	@Override
	public void remover(Integer id) {
		enderecoDao.remover(id);
	}

	/**
	 * Buscar uma lista de Perfis
	 */
	@Override
	public Optional<List<Endereco>> getList() {
		// TODO Auto-generated method stub
		return enderecoDao.getList();
	}

	/**
	 * Buscar uma Pessoa pelo ID
	 */
	@Override
	public Optional<Endereco> encontrar(Integer id) {
		// TODO Auto-generated method stub
		return enderecoDao.encontrar(id);
	}

}
