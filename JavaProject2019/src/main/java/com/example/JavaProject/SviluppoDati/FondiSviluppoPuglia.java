package com.example.JavaProject.SviluppoDati;

import java.io.* ;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Metadati{
	String nome();
	String tipo();
}

public class FondiSviluppoPuglia implements Serializable {
	
	@Metadati(nome="programma", tipo="String")
	private String programma;
	
	@Metadati(nome="asse", tipo="String")
	private String asse;
	
	@Metadati(nome="linea", tipo="String")
	private String linea;
	
	@Metadati(nome="azione", tipo="String")
	private String azione;
	
	@Metadati(nome="titoloProgetto", tipo="String")
	private String titoloProgetto;
	
	@Metadati(nome="ambitoIntervento", tipo="String")
	private String ambitoIntervento;
	
	@Metadati(nome="finanziamentoProgetto", tipo="Double")
	private double finanziamentoProgetto;
	
	@Metadati(nome="finanziamentoErogato", tipo="Double")
	private double finanziamentoErogato;
	
	@Metadati(nome="finanziamentoConcesso", tipo="Double")
	private double finanziamentoConcesso;
	
	@Metadati(nome="beneficiario", tipo="String")
	private String beneficiario;
	
	@Metadati(nome="formaGiuridica", tipo="String")
	private String formaGiuridica;
	
	@Metadati(nome="codiceAteco", tipo="String")
	private String codiceAteco;
	
	@Metadati(nome="localizzazioneInvestimento", tipo="String")
	private String localizzazioneInvestimento;
	
	@Metadati(nome="comune", tipo="String")
	private String comune;
	
	@Metadati(nome="codiceIstat", tipo="String")
	private String codiceIstat;
	
	@Metadati(nome="provincia", tipo="String")
	private String provincia;
	
	public FondiSviluppoPuglia(String programma, String asse, String linea,
			String azione, String titoloProgetto, String ambitoIntervento, 
			double finanziamentoProgetto, double finanziamentoErogato, 
			double finanziamentoConcesso, String beneficiario, String formaGiuridica,
			String codiceAteco, String localizzazioneInvestimento, String comune,
			String codiceIstat, String provincia) {
		
		super();
		this.programma = programma;
		this.asse = asse;
		this.linea = linea;
		this.azione = azione;
		this.titoloProgetto = titoloProgetto;
		this.ambitoIntervento = ambitoIntervento;
		this.finanziamentoProgetto = finanziamentoProgetto;
		this.finanziamentoErogato = finanziamentoErogato;
		this.finanziamentoConcesso = finanziamentoConcesso;
		this.beneficiario = beneficiario;
		this.formaGiuridica = formaGiuridica;
		this.codiceAteco = codiceAteco;
		this.localizzazioneInvestimento = localizzazioneInvestimento;
		this.comune = comune;
		this.codiceIstat = codiceIstat;
		this.provincia = provincia;
	}

	/**
	 * @return the programma
	 */
	public String getProgramma() {
		return programma;
	}

	/**
	 * @param programma the programma to set
	 */
	public void setProgramma(String programma) {
		this.programma = programma;
	}

	/**
	 * @return the asse
	 */
	public String getAsse() {
		return asse;
	}

	/**
	 * @param asse the asse to set
	 */
	public void setAsse(String asse) {
		this.asse = asse;
	}

	/**
	 * @return the linea
	 */
	public String getLinea() {
		return linea;
	}

	/**
	 * @param linea the linea to set
	 */
	public void setLinea(String linea) {
		this.linea = linea;
	}

	/**
	 * @return the azione
	 */
	public String getAzione() {
		return azione;
	}

	/**
	 * @param azione the azione to set
	 */
	public void setAzione(String azione) {
		this.azione = azione;
	}

	/**
	 * @return the titoloProgetto
	 */
	public String getTitoloProgetto() {
		return titoloProgetto;
	}

	/**
	 * @param titoloProgetto the titoloProgetto to set
	 */
	public void setTitoloProgetto(String titoloProgetto) {
		this.titoloProgetto = titoloProgetto;
	}

	/**
	 * @return the ambitoIntervento
	 */
	public String getAmbitoIntervento() {
		return ambitoIntervento;
	}

	/**
	 * @param ambitoIntervento the ambitoIntervento to set
	 */
	public void setAmbitoIntervento(String ambitoIntervento) {
		this.ambitoIntervento = ambitoIntervento;
	}

	/**
	 * @return the finanziamentoProgetto
	 */
	public double getFinanziamentoProgetto() {
		return finanziamentoProgetto;
	}

	/**
	 * @param finanziamentoProgetto the finanziamentoProgetto to set
	 */
	public void setFinanziamentoProgetto(double finanziamentoProgetto) {
		this.finanziamentoProgetto = finanziamentoProgetto;
	}

	/**
	 * @return the finanziamentoErogato
	 */
	public double getFinanziamentoErogato() {
		return finanziamentoErogato;
	}

	/**
	 * @param finanziamentoErogato the finanziamentoErogato to set
	 */
	public void setFinanziamentoErogato(double finanziamentoErogato) {
		this.finanziamentoErogato = finanziamentoErogato;
	}

	/**
	 * @return the finanziamentoConcesso
	 */
	public double getFinanziamentoConcesso() {
		return finanziamentoConcesso;
	}

	/**
	 * @param finanziamentoConcesso the finanziamentoConcesso to set
	 */
	public void setFinanziamentoConcesso(double finanziamentoConcesso) {
		this.finanziamentoConcesso = finanziamentoConcesso;
	}

	/**
	 * @return the beneficiario
	 */
	public String getBeneficiario() {
		return beneficiario;
	}

	/**
	 * @param beneficiario the beneficiario to set
	 */
	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}

	/**
	 * @return the formaGiuridica
	 */
	public String getFormaGiuridica() {
		return formaGiuridica;
	}

	/**
	 * @param formaGiuridica the formaGiuridica to set
	 */
	public void setFormaGiuridica(String formaGiuridica) {
		this.formaGiuridica = formaGiuridica;
	}

	/**
	 * @return the codiceAteco
	 */
	public String getCodiceAteco() {
		return codiceAteco;
	}

	/**
	 * @param codiceAteco the codiceAteco to set
	 */
	public void setCodiceAteco(String codiceAteco) {
		this.codiceAteco = codiceAteco;
	}

	/**
	 * @return the localizzazioneInvestimento
	 */
	public String getLocalizzazioneInvestimento() {
		return localizzazioneInvestimento;
	}

	/**
	 * @param localizzazioneInvestimento the localizzazioneInvestimento to set
	 */
	public void setLocalizzazioneInvestimento(String localizzazioneInvestimento) {
		this.localizzazioneInvestimento = localizzazioneInvestimento;
	}

	/**
	 * @return the comune
	 */
	public String getComune() {
		return comune;
	}

	/**
	 * @param comune the comune to set
	 */
	public void setComune(String comune) {
		this.comune = comune;
	}

	/**
	 * @return the codiceIstat
	 */
	public String getCodiceIstat() {
		return codiceIstat;
	}

	/**
	 * @param codiceIstat the codiceIstat to set
	 */
	public void setCodiceIstat(String codiceIstat) {
		this.codiceIstat = codiceIstat;
	}

	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public String toString() {
		return "FondiSviluppoPuglia [programma = " + programma + ", asse = " + asse +
				", linea = " + linea + ", azione = " + azione + ", titoloProgetto = "
				+ titoloProgetto + ", ambitoIntervento = " + ambitoIntervento + 
				", finanziamentoProgetto = " + finanziamentoProgetto +
				", finanziamentoErogato = " + finanziamentoErogato + 
				", finanziamentoConcesso = " + finanziamentoConcesso + ", beneficiario = "
				+ beneficiario + ", formaGiuridica = " + formaGiuridica + ", codiceAteco = "
				+ codiceAteco + ", localizzazioneInvestimento = " + localizzazioneInvestimento +
				", comune = " + comune + ", codiceIstat = " + codiceIstat + ", provincia = "
				+ provincia + "]";
		
	}
	
}
 










