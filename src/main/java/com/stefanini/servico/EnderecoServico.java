package com.stefanini.servico;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.EnderecoDao;
import com.stefanini.model.Endereco;
import com.stefanini.util.IGenericService;

public class EnderecoServico implements IGenericService<Endereco, Integer>{

	@Inject
	private EnderecoDao enderecoDao;

	@Override
	public Endereco salvar(@Valid Endereco endereco) {
		return enderecoDao.salvar(endereco);
	}

	@Override
	public Endereco atualizar(@Valid Endereco entity) {
		// TODO Auto-generated method stub
		return enderecoDao.atualizar(entity);
	}

	@Override
	public void remover(Integer id) {
		enderecoDao.remover(id);
	}

	@Override
	public List<Endereco> getList() {
		// TODO Auto-generated method stub
		return enderecoDao.getList();
	}

	@Override
	public Endereco encontrar(Integer id) {
		// TODO Auto-generated method stub
		return enderecoDao.encontrar(id);
	}

}