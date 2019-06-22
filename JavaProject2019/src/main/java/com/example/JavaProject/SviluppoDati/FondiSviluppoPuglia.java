package com.example.JavaProject.SviluppoDati;

import java.io.* ;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Metadati{
	String nome();
	String tipo();
}

/**
 * Classe per modellare le righe del file CSV
 */
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
	
	/**
	 * Costruttore di un oggetto della classe FondiSviluppoPuglia
	 * 
	 * @param programma
	 * @param asse
	 * @param linea
	 * @param azione
	 * @param titoloProgetto
	 * @param ambitoIntervento
	 * @param finanziamentoProgetto
	 * @param finanziamentoErogato
	 * @param finanziamentoConcesso
	 * @param beneficiario
	 * @param formaGiuridica
	 * @param codiceAteco
	 * @param localizzazioneInvestimento
	 * @param comune
	 * @param codiceIstat
	 * @param provincia
	 */
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
	 * @return programma
	 */
	public String getProgramma() {
		return programma;
	}

	/**
	 * @param programma 
	 */
	public void setProgramma(String programma) {
		this.programma = programma;
	}

	/**
	 * @return asse
	 */
	public String getAsse() {
		return asse;
	}

	/**
	 * @param asse
	 */
	public void setAsse(String asse) {
		this.asse = asse;
	}

	/**
	 * @return linea
	 */
	public String getLinea() {
		return linea;
	}

	/**
	 * @param linea
	 */
	public void setLinea(String linea) {
		this.linea = linea;
	}

	/**
	 * @return azione
	 */
	public String getAzione() {
		return azione;
	}

	/**
	 * @param azione
	 */
	public void setAzione(String azione) {
		this.azione = azione;
	}

	/**
	 * @return titoloProgetto
	 */
	public String getTitoloProgetto() {
		return titoloProgetto;
	}

	/**
	 * @param titoloProgetto
	 */
	public void setTitoloProgetto(String titoloProgetto) {
		this.titoloProgetto = titoloProgetto;
	}

	/**
	 * @return ambitoIntervento
	 */
	public String getAmbitoIntervento() {
		return ambitoIntervento;
	}

	/**
	 * @param ambitoIntervento
	 */
	public void setAmbitoIntervento(String ambitoIntervento) {
		this.ambitoIntervento = ambitoIntervento;
	}

	/**
	 * @return finanziamentoProgetto
	 */
	public double getFinanziamentoProgetto() {
		return finanziamentoProgetto;
	}

	/**
	 * @param finanziamentoProgetto
	 */
	public void setFinanziamentoProgetto(double finanziamentoProgetto) {
		this.finanziamentoProgetto = finanziamentoProgetto;
	}

	/**
	 * @return finanziamentoErogato
	 */
	public double getFinanziamentoErogato() {
		return finanziamentoErogato;
	}

	/**
	 * @param finanziamentoErogato
	 */
	public void setFinanziamentoErogato(double finanziamentoErogato) {
		this.finanziamentoErogato = finanziamentoErogato;
	}

	/**
	 * @return finanziamentoConcesso
	 */
	public double getFinanziamentoConcesso() {
		return finanziamentoConcesso;
	}

	/**
	 * @param finanziamentoConcesso
	 */
	public void setFinanziamentoConcesso(double finanziamentoConcesso) {
		this.finanziamentoConcesso = finanziamentoConcesso;
	}

	/**
	 * @return beneficiario
	 */
	public String getBeneficiario() {
		return beneficiario;
	}

	/**
	 * @param beneficiario
	 */
	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}

	/**
	 * @return formaGiuridica
	 */
	public String getFormaGiuridica() {
		return formaGiuridica;
	}

	/**
	 * @param formaGiuridica
	 */
	public void setFormaGiuridica(String formaGiuridica) {
		this.formaGiuridica = formaGiuridica;
	}

	/**
	 * @return codiceAteco
	 */
	public String getCodiceAteco() {
		return codiceAteco;
	}

	/**
	 * @param codiceAteco
	 */
	public void setCodiceAteco(String codiceAteco) {
		this.codiceAteco = codiceAteco;
	}

	/**
	 * @return localizzazioneInvestimento
	 */
	public String getLocalizzazioneInvestimento() {
		return localizzazioneInvestimento;
	}

	/**
	 * @param localizzazioneInvestimento
	 */
	public void setLocalizzazioneInvestimento(String localizzazioneInvestimento) {
		this.localizzazioneInvestimento = localizzazioneInvestimento;
	}

	/**
	 * @return comune
	 */
	public String getComune() {
		return comune;
	}

	/**
	 * @param comune
	 */
	public void setComune(String comune) {
		this.comune = comune;
	}

	/**
	 * @return codiceIstat
	 */
	public String getCodiceIstat() {
		return codiceIstat;
	}

	/**
	 * @param codiceIstat
	 */
	public void setCodiceIstat(String codiceIstat) {
		this.codiceIstat = codiceIstat;
	}

	/**
	 * @return provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	/**
	 * @return una stringa che rappresenta l'oggetto
	 */
	@Override 
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
 










