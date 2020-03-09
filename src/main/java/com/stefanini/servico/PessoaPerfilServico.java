package com.stefanini.servico;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.swing.text.html.Option;
import javax.validation.Valid;

import com.stefanini.dao.PessoaPerfilDao;
import com.stefanini.model.PessoaPerfil;
import com.stefanini.util.IGenericService;

/**
 * Classe que contém regras de negócio para a Entidade associativa
 */
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
	public Optional<List<PessoaPerfil>> getList() {
		// TODO Auto-generated method stub
		return pessoaPerfilDao.getList();
	}

	@Override
	public Optional<PessoaPerfil> encontrar(Integer id) {
		// TODO Auto-generated method stub
		return pessoaPerfilDao.encontrar(id);
	}

}
