package com.example.JavaProject.SviluppoDati;

public class StrStatistics {
	
    private String stringa;
    private int rip;        //ripetizioni di una certa stringa
    
    /**
     * 
     * @param stringa
     * @param rip
     */

    /**
	 * Costruttore
	 */
    public StrStatistics(String stringa, int rip) {
		this.stringa = stringa;
		this.rip = rip;
	}

	/**
	 * @return the stringa
	 */
	public String getStringa() {
		return stringa;
	}

	/**
	 * @param stringa the stringa to set
	 */
	public void setStringa(String stringa) {
		this.stringa = stringa;
	}

	/**
	 * @return the rip
	 */
	public int getRip() {
		return rip;
	}

	/**
	 * @param rip the rip to set
	 */
	public void setRip(int rip) {
		this.rip = rip;
	}
    
	@Override
	public String toString() {
		return "Statistiche stringhe [Stringa = " + stringa + ", rip = " + rip + "]";
	}


}
