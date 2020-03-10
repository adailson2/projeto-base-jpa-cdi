package com.stefanini.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_PERFIL")
public class Perfil implements Serializable {

	/**
	 * Serializacao da Classe
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ID da Tabela
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CO_SEQ_PERFIL")
	private Integer id;

	/**
	 * Nome do Perfil
	 */
	@Size(min = 3, max = 255)
    @Column(name = "NO_PERFIL", length = 255, nullable = true)
	private String perfil;

	/**
	 * Descrição do Perfil
	 */
	@Size(min = 3, max = 1000)
	@Column(name = "DS_PERFIL", length = 1000, nullable = false)
	private String descricao;

	/**
	 * Data e hora da inclusão
	 */
	@Column(name = "DT_HORA_INCLUSAO", nullable = false)
	private LocalDateTime horaInclusao;

	/**
	 * Data e hora da inclusão
	 */
	@Column(name = "DT_HORA_ALTERACAO", nullable = false)
	private LocalDateTime horaAlteracao;

	public Perfil() {
	}

	/**
	 * Construtor da Classe, Obrigando receber todos os parametros
	 * @param perfil
	 * @param descricao
	 * @param horaInclusao
	 * @param horaAlteracao
	 */
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Perfil perfil = (Perfil) o;
		return Objects.equals(id, perfil.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", perfil=" + perfil + ", descricao=" + descricao + ", horaInclusao=" + horaInclusao
				+ ", horaAlteracao=" + horaAlteracao + "]";
	}

}
