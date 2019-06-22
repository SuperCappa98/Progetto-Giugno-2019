package com.example.JavaProject.SviluppoDati;

import java.io.Serializable;
/**
 * Classe che definisce un oggetto Metadata per ottenere le informazioni essenziali degli attributi
 * della classe FondiSviluppiPuglia, ovvero il nome e il tipo dell'attributo
 */
public class Metadata implements Serializable {
	public static final long serialVersionUID = 1L; 
	private String nome;
	private String tipo;

	/**
	 * @param nome
	 * @param tipo
	 */
	public Metadata (String nome, String tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}

	/**
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * @return una stringa che rappresenta l'oggetto
	 */
	@Override 
	public String toString() {
		return "Metadata [nome = " + nome + ", tipo = " + tipo + "]";
	}

}
