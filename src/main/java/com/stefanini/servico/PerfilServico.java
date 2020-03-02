package com.stefanini.servico;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.PerfilDao;
import com.stefanini.model.Perfil;
import com.stefanini.util.IGenericService;

public class PerfilServico implements IGenericService<Perfil, Long>{

	@Inject
	private PerfilDao perfilDao;

	@Override
	public Perfil salvar(@Valid Perfil perfil) {
		return perfilDao.salvar(perfil);
	}

	@Override
	public Perfil atualizar(@Valid Perfil entity) {
		// TODO Auto-generated method stub
		return perfilDao.atualizar(entity);
	}

	@Override
	public void remover(Long id) {
		perfilDao.remover(id);
	}

	@Override
	public List<Perfil> getList() {
		// TODO Auto-generated method stub
		return perfilDao.getList();
	}

	@Override
	public Perfil encontrar(Long id) {
		// TODO Auto-generated method stub
		return perfilDao.encontrar(id);
	}

}