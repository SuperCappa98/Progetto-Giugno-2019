package com.example.JavaProject.SviluppoDati;

import java.util.*;

public class Statistics {
	
	/**
	 * 
	 * @param lista
	 * @return avg
	 */
	 public static double getAvg(Vector<Double> lista) { //lista è un vettore dinamico che contiene elementi di tipo double 
		 double avg;
		 avg = (getSum(lista)/lista.size());
		 return avg;
	 }
	 
	/**
	 * 
	 * @param lista 
	 * @return min
	 */
	 public static double getMin(Vector<Double> lista) {
		 double min = lista.get(0);                        //lista.get(0) ritorna il valore dell'elemento della lista in posizione 0
		 for(int i = 1; i<lista.size(); i++) {
		   if(min > lista.get(i)) {
			   min = lista.get(i);
		   }
		 }
		 return min;
	 }
	   
	 /**
	  * 
      * @param lista
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
	  * 
	  * @param lista 
      * @return devStd
      */
	  public static double getDevStd(Vector<Double> lista) {
	     double avg = getAvg(lista);                    
	     double sommaScarti = 0;
	     for(double elemento : lista) {                   //il ciclo continua fino a che non ha scorso tutti gli elementi della lista
		    sommaScarti += Math.pow(elemento-avg, 2);
		 }
	     double devStd = Math.sqrt(sommaScarti/lista.size());
		 return devStd;
	  }
	  
     /**
	  * 
	  * @param lista
      * @return sum
	  */
	  public static double getSum(Vector<Double> lista) {
	     double sum = 0;
		 for(double elemento : lista)
		    sum += elemento;
		 return sum;
	  }

	  /**
	   * 
	   * @param str
	   * @return stringStat
	   */ 
	  public static Vector<StrStatistics> getStringStatistics(Vector<String> str){  //restituisce una lista di oggetti StrStatistics
		  Vector<StrStatistics> stringStat = new  Vector<StrStatistics>();			  
		  String stringa;
		  int ripSupporto;
		  StrStatistics supporto;
		  Boolean flagPresenza;
		  for(int i = 0;i < str.size();i++){ 					 //utilizzo il metodo size di Vector
			  flagPresenza = false;								 
			  stringa = str.get(i);							     //utilizzo metodo get di Vector
	          ripSupporto = 1;
		      for(int j = 0;j < stringStat.size() && !flagPresenza;j++){
		          if(stringa.equals(stringStat.get(j).getStringa())){ //confronta stringa con il campo stringa dell'elemento j-esimo di stringStat
		    	  flagPresenza = true;
		          ripSupporto = stringStat.get(j).getRip() + 1;
		          supporto = new StrStatistics(stringa,ripSupporto);
		          stringStat.set(j, supporto);					 //in posizione j di stringStat metto l'oggetto supporto
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
