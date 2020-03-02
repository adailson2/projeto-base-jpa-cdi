package com.stefanini.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_ENDERECO")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "co_seq_endereco")
	private Integer id;
	
	@Size(min = 3, max = 150)
    @Column(name = "ds_logradouro", length = 150, nullable = true)
	private String logradouro;

	@Size(min = 3, max = 150)
    @Column(name = "ds_complemento", length = 150, nullable = true)
	private String complemento;
	
	@Size(min = 3, max = 250)
    @Column(name = "ds_bairro", length = 150, nullable = true)
	private String bairro;
	
    @Column(name = "ds_cidade", nullable = true)
	private String cidade;
	
    @Column(name = "co_uf", nullable = true)
	private String uf;
	
	@Size(min = 8, max = 8)
    @Column(name = "ds_cep", length = 8, nullable = true)
	private String cep;
	
	public Endereco() {
	}

	public Endereco(String logradouro, String complemento, String bairro, String cidade, String uf, String cep) {
		super();
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", logradouro=" + logradouro + ", complemento=" + complemento + ", bairro="
				+ bairro + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + "]";
	}
	
	

}