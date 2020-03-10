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

	/**
	 * ID da Tabela
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CO_SEQ_PESSOA_PERFIL")
	private Integer id;

	/**
	 * Relacionamento associativo
	 */
	@ManyToOne
    @JoinColumn(name = "CO_SEQ_PESSOA")
    private Pessoa pessoa;

	/**
	 * Relacionamento associativo
	 */
	@ManyToOne
    @JoinColumn(name = "CO_SEQ_PERFIL")
    private Perfil perfil;

	public PessoaPerfil() {
	}

	/**
	 * Construtor da Classe, Obrigando receber todos os parametros
	 * @param pessoa
	 * @param perfil
	 */
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
