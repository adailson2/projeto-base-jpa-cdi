package com.stefanini.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_PESSOA")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "co_seq_pessoa")
	private Long id;

	@OneToMany(orphanRemoval=true)
    @JoinColumn(name="co_seq_pessoa", foreignKey = @ForeignKey(name="co_seq_pessoa_co_seq_pessoa"))
	private List<PessoaPerfil> pessoaPerfil = new ArrayList<PessoaPerfil>();
	
	@OneToMany(orphanRemoval=true)
    @JoinColumn(name="co_seq_pessoa", foreignKey = @ForeignKey(name="co_seq_pessoa_co_seq_pessoa"))
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	@Size(min = 3, max = 400)
    @Column(name = "no_nome", length = 400, nullable = false)
	private String nome;
	
	@Email
	@Size(min = 3, max = 200)
	@Column(name = "no_email", length = 200, unique = true, nullable = false)
	private String email;
	
	@Column(name = "dt_nascimento", nullable = true)
	private LocalDate dataNascimento;
	
	@Column(name = "st_pessoa", nullable = false)
	private Boolean situacao;
	
	
	public Pessoa() {
	}

	public Pessoa(String nome, String email, LocalDate dataNascimento, Boolean situacao) {
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

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
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

	@Override
	public String toString() {
		return "Pessoa [getNome()=" + getNome() + ", getEmail()=" + getEmail() + ", getDataNascimento()="
				+ getDataNascimento() + ", getSituacao()=" + getSituacao() + "]";
	}

}