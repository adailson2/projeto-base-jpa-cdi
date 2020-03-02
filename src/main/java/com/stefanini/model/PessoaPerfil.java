package com.stefanini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PESSOA_PERFIL")
public class PessoaPerfil {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "co_seq_pessoa_perfil")
	private Integer id;

	@ManyToOne
    @JoinColumn(name = "co_seq_pessoa")
    private Pessoa pessoa;
	
	@ManyToOne
    @JoinColumn(name = "co_seq_perfil")
    private Perfil perfil;
		
	public PessoaPerfil() {
	}

	public PessoaPerfil(Pessoa pessoa, Perfil perfil) {
		super();
		this.pessoa = pessoa;
		this.perfil = perfil;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "PessoaPerfil [id=" + id + ", pessoa=" + pessoa + ", perfil=" + perfil + "]";
	}

}