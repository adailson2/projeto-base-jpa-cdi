package com.stefanini.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_PESSOA")
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
	@Column(name = "co_seq_pessoa")
	private Long id;

	/**
	 * Nome da pessoa
	 */
	@Size(min = 3, max = 400)
    @Column(name = "no_nome", length = 400, nullable = false)
	private String nome;

	/**
	 * Email da Pessoa
	 */
	@Email
	@Size(min = 3, max = 200)
	@Column(name = "no_email", length = 200, unique = true, nullable = false)
	private String email;

	/**
	 * Data da Nascimento
	 */
	@Column(name = "dt_nascimento", nullable = true)
	private LocalDate dataNascimento;

	/**
	 * Situação da pessoa
	 */
	@Column(name = "st_pessoa", nullable = false)
	private Boolean situacao;

	/**
	 * Relacionamento associativo
	 */
	@OneToMany(orphanRemoval=true)
	@JoinColumn(name="co_seq_pessoa", foreignKey = @ForeignKey(name="co_seq_pessoa_co_seq_pessoa"))
	private List<PessoaPerfil> pessoaPerfil = new ArrayList<PessoaPerfil>();

	@OneToMany(mappedBy= "pessoa")
	private Set<Endereco> enderecos;

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

	public List<PessoaPerfil> getPessoaPerfil() {
		return pessoaPerfil;
	}

	public void setPessoaPerfil(List<PessoaPerfil> pessoaPerfil) {
		this.pessoaPerfil = pessoaPerfil;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
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
