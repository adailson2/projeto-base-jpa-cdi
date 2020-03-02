package com.stefanini.model;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_PERFIL")
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "co_seq_perfil")
	private Integer id;
	
	@Size(min = 3, max = 255)
    @Column(name = "no_perfil", length = 255, nullable = true)
	private String perfil;
	
	@Size(min = 3, max = 1000)
	@Column(name = "ds_perfil", length = 1000, nullable = false)
	private String descricao;
	
	@Column(name = "dt_hora_inclusao", nullable = false)
	private LocalDateTime horaInclusao;
	
	@Column(name = "dt_hora_alteracao", nullable = false)
	private LocalDateTime horaAlteracao;
	
	public Perfil() {
	}

	public Perfil(String perfil, String descricao, LocalDateTime horaInclusao,  LocalDateTime horaAlteracao) {
		super();
		this.perfil = perfil;
		this.descricao = descricao;
		this.horaInclusao = horaInclusao;
		this.horaAlteracao = horaAlteracao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getHoraInclusao() {
		return horaInclusao;
	}

	public void setHoraInclusao(LocalDateTime horaInclusao) {
		this.horaInclusao = horaInclusao;
	}

	public LocalDateTime getHoraAlteracao() {
		return horaAlteracao;
	}

	public void setHoraAlteracao(LocalDateTime horaAlteracao) {
		this.horaAlteracao = horaAlteracao;
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", perfil=" + perfil + ", descricao=" + descricao + ", horaInclusao=" + horaInclusao
				+ ", horaAlteracao=" + horaAlteracao + "]";
	}

}