package com.stefanini.servico;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.PerfilDao;
import com.stefanini.model.Perfil;
import com.stefanini.util.IGenericService;

/**
 * Classe que contém regras de negócio para o Perfil
 */
public class PerfilServico implements IGenericService<Perfil, Integer>{

	@Inject
	private PerfilDao perfilDao;

	/**
	 * Salvar os dados de um perfil
	 */
	@Override
	public Perfil salvar(@Valid Perfil perfil) {
		return perfilDao.salvar(perfil);
	}

	/**
	 * Atualizar os dados de um perfil
	 */
	@Override
	public Perfil atualizar(@Valid Perfil entity) {
		// TODO Auto-generated method stub
		return perfilDao.atualizar(entity);
	}

	/**
	 * Remover um perfil pelo id
	 */
	@Override
	public void remover(Integer id) {
		perfilDao.remover(id);
	}

	/**
	 * Buscar uma lista de Perfis
	 */
	@Override
	public Optional<List<Perfil>> getList() {
		// TODO Auto-generated method stub
		return perfilDao.getList();
	}

	/**
	 * Buscar uma Pessoa pelo ID
	 */
	@Override
	public Optional<Perfil> encontrar(Integer id) {
		// TODO Auto-generated method stub
		return perfilDao.encontrar(id);
	}

}
