package br.unipe.matheus.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Atendimento {


	private @Id @GeneratedValue Long id;
	@Column(nullable = false)
	private String coordenador;
	@Column(nullable = false)
	private String assunto;
	@Column(nullable = false)
	private String descricao;
	@Column(nullable = false)
	private String data;
	
	public Atendimento() {}
	
	public Atendimento(String coordenador, String assunto, String descricao, String data) {
		super();
		this.coordenador = coordenador;
		this.assunto = assunto;
		this.descricao = descricao;
		this.data = data;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCoordenador() {
		return coordenador;
	}
	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}	 

	  @Override
	  public String toString() {
	    return "Atendimento{" + "id=" + this.id + ", name='" + this.coordenador + '\'' + ", role='" + this.assunto + '\'' + ", name='" + this.descricao + '\'' + ", name='" + this.data + '\'' +'}';
	  }

	
}
