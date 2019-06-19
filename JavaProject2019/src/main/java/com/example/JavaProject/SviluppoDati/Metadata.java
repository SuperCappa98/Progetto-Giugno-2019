package com.example.JavaProject.SviluppoDati;

import java.io.Serializable;

public class Metadata implements Serializable {
	public static final long serialVersionUID = 1; 
	private String nome;
	private String tipo;

	public Metadata (String nome, String tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Metadata [nome = " + nome + ", tipo = " + tipo + "]";
	}

}
