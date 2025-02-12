package com.camara.demo.projetos;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.camara.demo.pessoa.Deputado;

@Entity
public class LeiComplementar{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	
	@NotNull @OneToOne 
	protected Deputado autor;
	@NotNull @Size(min = 1) @Column protected String ano;
	@Column protected String codigo;
	@NotNull @Size(min = 1) @Column protected String ementa;
	@NotNull @Size(min = 1) @Column protected String interesses;
	@Column protected String situacao = "EM VOTACAO (CCJC)";
	@NotNull @Size(min = 1) @Column protected String endereco;
	
    @ElementCollection
	private Map<String, String> votacoes;
    
    private String local = "CCJC";
	
	@NotNull @Size(min = 1) private String artigos;
	
	public LeiComplementar() {
		
	}
	
	public LeiComplementar(Deputado autor, String ano, String ementa, String interesses, String url, String artigos) {
		this.autor = autor;
		this.ano = ano;
		this.ementa = ementa;
		this.interesses = interesses;
		this.endereco = url;
		this.artigos = artigos;
		this.codigo = ano + "/" + ano;
	}
	

	
	public long getId() {
		return id;
	}
	
	public Deputado getAutor() {
		return autor;
	}
	
	public String getAno() {
		return ano;
	}
	
	public String getEmenta() {
		return ementa;
	}
	
	public String[] getListaInteresses() {
		return interesses.split(",");
	}
	
	public String getInteresses() {
		return interesses;
	}
	
	public String getSituacao() {
		return situacao;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getArtigos() {
		return artigos;
	}
	
	public String getCodigo() {
		return id + "/" + ano;
	}
	
	public String toString() {
		return "Projeto de Lei Complementar - " + getCodigo() + " - " + autor + " - " + ementa + " - " + artigos + " - " + situacao;
	}
	
	public String resultVotacao(String result, String local, String prox) {
		votacoes.put(local, result);
		this.situacao = "Em Votacao (" + prox + ")";
		return (result + " (" + local + ")");
	}
	
	
	public String getLocal() {
		return local;
	}
}
