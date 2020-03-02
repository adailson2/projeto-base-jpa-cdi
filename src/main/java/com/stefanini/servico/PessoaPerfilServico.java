package com.stefanini.servico;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.PessoaPerfilDao;
import com.stefanini.model.PessoaPerfil;
import com.stefanini.util.IGenericService;

public class PessoaPerfilServico implements IGenericService<PessoaPerfil, Integer>{

	@Inject
	private PessoaPerfilDao pessoaPerfilDao;

	@Override
	public PessoaPerfil salvar(@Valid PessoaPerfil pessoaPerfil) {
		return pessoaPerfilDao.salvar(pessoaPerfil);
	}

	@Override
	public PessoaPerfil atualizar(@Valid PessoaPerfil entity) {
		// TODO Auto-generated method stub
		return pessoaPerfilDao.atualizar(entity);
	}

	@Override
	public void remover(Integer id) {
		pessoaPerfilDao.remover(id);
	}

	@Override
	public List<PessoaPerfil> getList() {
		// TODO Auto-generated method stub
		return pessoaPerfilDao.getList();
	}

	@Override
	public PessoaPerfil encontrar(Integer id) {
		// TODO Auto-generated method stub
		return pessoaPerfilDao.encontrar(id);
	}

}