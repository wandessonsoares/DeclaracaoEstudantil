package br.edu.ifpb.pweb.audien.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Instituicao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=50)   
	private String nome;
	
	@Column(length=7)   
	private String sigla;
	
	@Column(length=15)   
	private String fone;
	
	@Column
	private String ultimoperiodo;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="instituicao")
	private Set<PeriodoLetivo> periodos = new HashSet<PeriodoLetivo>();

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
	
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public Set<PeriodoLetivo> getperiodos() {
		return periodos;
	}

	public void setperiodos(Set<PeriodoLetivo> periodos) {
		this.periodos = periodos;
	}

	public void addPeriodo(PeriodoLetivo novoPeriodo) {
		novoPeriodo.setInstituicao(this);
		this.getperiodos().add(novoPeriodo);
		
	}
	

	public String getUltimoperiodo() {
		return ultimoperiodo;
	}

	public void setUltimoperiodo(String ultimoperiodo) {
		this.ultimoperiodo = ultimoperiodo;
	}

	@Override
	public String toString() {
		return "Instituicao [id=" + id + ", nome=" + nome + ", sigla=" + sigla
				+ ", fone=" + fone + ", ultimoperiodo=" + ultimoperiodo
				+ ", periodos=" + periodos + "]";
	}

}
