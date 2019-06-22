package com.example.JavaProject.SviluppoDati;

/**
 *Classe per istanziare oggetti contenenti la stringa in questione e il suo numero di ripetizioni
 */
public class StrStatistics {
	
    private String stringa;
    private int rip;        
    
    /**
     * Costruttore
     * 
     * @param stringa
     * @param rip	   Numero di volte che la stringa si ripete
     */
    public StrStatistics(String stringa, int rip) {
		this.stringa = stringa;
		this.rip = rip;
	}

	/**
	 * @return stringa
	 */
	public String getStringa() {
		return stringa;
	}

	/**
	 * @param stringa
	 */
	public void setStringa(String stringa) {
		this.stringa = stringa;
	}

	/**
	 * @return rip
	 */
	public int getRip() {
		return rip;
	}

	/**
	 * @param rip
	 */
	public void setRip(int rip) {
		this.rip = rip;
	}
    

	/**
	 * @return una stringa che rappresenta l'oggetto
	 */
	@Override
	public String toString() {
		return "Statistiche stringhe [Stringa = " + stringa + ", rip = " + rip + "]";
	}

}
