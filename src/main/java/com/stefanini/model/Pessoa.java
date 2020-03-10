package com.stefanini.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_PESSOA")
@NamedQueries(value = {
		@NamedQuery(name = "Pessoa.findByNome",
				query = "select p from Pessoa p where p.nome=:nome"),
		@NamedQuery(name = "Pessoa.findPerfilsAndEnderecosByNome",
				query = "select  p from Pessoa p  JOIN FETCH p.perfils perfil JOIN FETCH p.enderecos enderecos where p.nome=:nome")
})
public class Pessoa implements Serializable {

	/**
	 * Serializacao da Classe
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ID da Tabela
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CO_SEQ_PESSOA")
	private Long id;

	/**
	 * Nome da pessoa
	 */
	@Size(min = 3, max = 400)
    @Column(name = "NO_NOME", length = 400, nullable = false)
	private String nome;

	/**
	 * Email da Pessoa
	 */
	@Email
	@Size(min = 3, max = 200)
	@Column(name = "DS_EMAIL", length = 200, unique = true, nullable = false)
	private String email;

	/**
	 * Data da Nascimento
	 */
	@Column(name = "DT_NASCIMENTO", nullable = true)
	private LocalDate dataNascimento;

	/**
	 * Situação da pessoa
	 */
	@Column(name = "ST_PESSOA", nullable = false)
	private Boolean situacao;

	/**
	 * Mapeamento de Enderecos Unidirecional
	 */
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_SEQ_PESSOA",referencedColumnName = "CO_SEQ_PESSOA")
	private Set<Endereco> enderecos;

	/**
	 * Mapeamento de Perfis Unidirecional
	 */
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(
			name = "TB_PESSOA_PERFIL",
			joinColumns = {@JoinColumn(name = "CO_SEQ_PESSOA")},
			inverseJoinColumns = {@JoinColumn(name = "CO_SEQ_PERFIL")}
	)
	private Set<Perfil> perfils;

	/**
	 * Metodo construtor da classe
	 */
	public Pessoa() {
	}

	/**
	 * Construtor da Classe, Obrigando receber todos os parametros
	 * @param nome
	 * @param email
	 * @param dataNascimento
	 * @param situacao
	 */
	public Pessoa(@NotNull String nome, @NotNull String email, @NotNull LocalDate dataNascimento, @NotNull Boolean situacao) {
		super();
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.situacao = situacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<Perfil> getPerfils() {
		return perfils;
	}

	public void setPerfils(Set<Perfil> perfils) {
		this.perfils = perfils;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pessoa pessoa = (Pessoa) o;
		return id.equals(pessoa.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Pessoa [getNome()=" + getNome() + ", getEmail()=" + getEmail() + ", getDataNascimento()="
				+ getDataNascimento() + ", getSituacao()=" + getSituacao() + "]";
	}
}
