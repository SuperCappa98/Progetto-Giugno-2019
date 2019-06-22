package com.example.JavaProject.SviluppoDati;

import java.util.*;

/**
 * Classe che contiene i metodi per calcolare le statistiche sui dati
 */
public class Statistics {
	
	/**
	 * Metodo che calcola la media e la restituisce
	 * 
	 * @param lista		è un vettore che contiene elementi di tipo Double
	 * 
	 * @return avg
	 */
	 public static double getAvg(Vector<Double> lista) { 
		 double avg;
		 avg = (getSum(lista)/lista.size());
		 return avg;
	 }
	 
	/**
	 * Metodo che trova il valore minimo e lo restituisce
	 * 
	 * @param lista 
	 * 
	 * @return min
	 */
	 public static double getMin(Vector<Double> lista) {
		 double min = lista.get(0);                        //lista.get(i) ritorna il valore che si trova in posizione i della lista
		 for(int i = 1; i<lista.size(); i++) {
		   if(min > lista.get(i)) {
			   min = lista.get(i);
		   }
		 }
		 return min;
	 }
	   
	 /**
	  * Metodo che trova il valore massimo e lo restituisce
	  * 
      * @param lista
      * 
      * @return max
      */
	  public static double getMax(Vector<Double> lista) {
	     double max = lista.get(0);
		 for(int i = 1; i<lista.size(); i++) {
			 if(max < lista.get(i)) {
			    max = lista.get(i);
			  }
		  }
		 return max;
	  }
	   
     /**
	  * Metodo che calcola la deviazione standard e la restituisce
	  * 
	  * @param lista 
	  * 
      * @return devStd
      */
	  public static double getDevStd(Vector<Double> lista) {
	     double avg = getAvg(lista);                    
	     double sommaScarti = 0;
	     for(double elemento : lista) {                   
		    sommaScarti += Math.pow(elemento-avg, 2);
		 }
	     double devStd = Math.sqrt(sommaScarti/lista.size());
		 return devStd;
	  }
	  
     /**
	  * Metodo che calcola la somma e la restituisce
	  * 
	  * @param lista
	  * 
      * @return sum
	  */
	  public static double getSum(Vector<Double> lista) {
	     double sum = 0;
		 for(double elemento : lista)
		    sum += elemento;
		 return sum;
	  }

	  /**
	   * Metodo per le statistiche sulle stringhe
	   * 
	   * @param str 	vettore di stringhe
	   * 
	   * @return una lista di oggetti StrStatistic che indicano per ogni stringa le sue ripetizioni
	   */ 
	  public static Vector<StrStatistics> getStringStatistics(Vector<String> str){  
		  Vector<StrStatistics> stringStat = new  Vector<StrStatistics>();			  
		  String stringa;
		  int ripSupporto;
		  StrStatistics supporto;
		  Boolean flagPresenza;
		  for(int i = 0;i < str.size();i++){ 					 		 //utilizza metodo size di Vector
			  flagPresenza = false;								 
			  stringa = str.get(i);							     		 //utilizza metodo get di Vector
	          ripSupporto = 1;
		      for(int j = 0;j < stringStat.size() && !flagPresenza;j++){
		          if(stringa.equals(stringStat.get(j).getStringa())){    //confronta stringa con il campo stringa dell'elemento j-esimo di stringStat
		    	  flagPresenza = true;
		          ripSupporto = stringStat.get(j).getRip() + 1;
		          supporto = new StrStatistics(stringa,ripSupporto);
		          stringStat.set(j, supporto);					 		 //in posizione j di stringStat mette l'oggetto supporto
		          }
		      }
		    if(!flagPresenza) {
		    	supporto = new StrStatistics(stringa,ripSupporto);
		    	stringStat.add(supporto);
		    }
		  }
		  return stringStat; 									 
	  }

}
