package com.stefanini.dao;

import com.stefanini.dao.abstracao.GenericDao;
import com.stefanini.model.Pessoa;
import com.stefanini.model.PessoaPerfil;

public class PessoaPerfilDao extends GenericDao<PessoaPerfil, Integer> {
    public PessoaPerfilDao() {
        super(PessoaPerfil.class);
    }
}
