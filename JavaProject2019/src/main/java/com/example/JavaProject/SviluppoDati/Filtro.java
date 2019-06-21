package com.example.JavaProject.SviluppoDati;

import java.lang.reflect.*;
import java.util.*;

/**
 * 
 * @param modelloFiltro
 */
public class Filtro {
	
	private String modelloFiltro;			//attributo

	public Filtro(String modelloFiltro) {   //costruttore
		this.modelloFiltro = modelloFiltro;
	}
	
	
	/**
	 * Metodo per fare una ricerca filtrata nella lista di input e restituire una lista filtrata
	 * 
	 * @param attributo della classe FondiSviluppoPuglia
	 * @param dato1 riferimento per il filtraggio
	 * @param dato2 riferimento per il filtraggio conl'operatore $or
	 * @param listaInput Lista data in input su cui il metodo farà il filtraggio
	 * @return Lista filtrata
	 */
	public Object Research (String attributo, String dato1, String dato2, Vector <FondiSviluppoPuglia> listaInput){
		
		boolean isNumber = true;
		Vector<FondiSviluppoPuglia> listaOutput = new Vector<FondiSviluppoPuglia>();
		Method metodo;			  //istanzia un oggetto della classe Method contenuta in java.lang.reflect.*
		Double datoDouble1 = 0.0;
		Double datoDouble2 = 0.0;
		
		
		//verifica che l'attributo immesso sia presente nella classe FondiSviluppoPuglia
		try { 				
			metodo = FondiSviluppoPuglia.class.getMethod("get" + attributo.substring(0,1).toUpperCase() + attributo.substring(1));
		}
		catch(NoSuchMethodException e) {
			e.printStackTrace();
			return "L'attributo immesso non esiste";
		}
		
		
		//converte i valori di riferimento in double, se essi sono stringhe si entra nel catch
		try {
			datoDouble1 = Double.parseDouble(dato1);
			datoDouble2 = Double.parseDouble(dato2);
		}
		catch(NumberFormatException e) {
			isNumber = false;
		}
		
		
		//Logical operator $not
		//La lista in output contiene tutti i valori della lista in input tranne quelli uguali al valore di riferimento
		if(modelloFiltro.equals("$not")) {
			if(isNumber) {
			   try {
			      for(FondiSviluppoPuglia obj : listaInput) {
					if(metodo.invoke(obj) instanceof Double) {
					   Double temp = (Double)metodo.invoke(obj);
					   if(!temp.equals(datoDouble1)) { 
					      listaOutput.add(obj);		
					   }
				    }
				  }
			   }
				
			   catch(IllegalAccessException e) {
					e.printStackTrace();
			   }
			   catch(InvocationTargetException e) {
					e.printStackTrace();
			   }
			}
			else {
			   try {
				  for(FondiSviluppoPuglia obj : listaInput) {
					 if(metodo.invoke(obj) instanceof String) {
						String temp = (String)metodo.invoke(obj);
						if(!temp.equals(dato1)) {
						   listaOutput.add(obj);
						}
					 }
				  }
			  }
			   catch(IllegalAccessException e) {
				  e.printStackTrace();
			   }
			   catch(InvocationTargetException e) {
				  e.printStackTrace();
			   }
			}
		}
		
		
		//Logical operator $or
		//La lista in output contiene i valori uguali a uno o all'altro valore di riferimento
		if(modelloFiltro.equals("$or")) {
			if(isNumber) {
				try {
					 for(FondiSviluppoPuglia obj : listaInput) {
						if(metodo.invoke(obj) instanceof Double) {
							Double temp = (Double)metodo.invoke(obj);
							if(temp.equals(datoDouble1) || temp.equals(datoDouble2)) {
								listaOutput.add(obj);
							}
					     }
					 }
				}
				catch(IllegalAccessException e) {
					e.printStackTrace();
				}
				catch(InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			else {
				try {
					 for(FondiSviluppoPuglia obj : listaInput) {
						if(metodo.invoke(obj) instanceof String) {
						   String temp = (String)metodo.invoke(obj);
						   if(temp.equals(dato1) || temp.equals(dato2)) {
								listaOutput.add(obj);
						   }
						}
					 }
				}
				catch(IllegalAccessException e) {
					e.printStackTrace();
				}
				catch(InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		//Conditional operator $gt
		//La lista in output contiene tutti i valori maggiori del valore di riferimento
		if(modelloFiltro.equals("$gt")) {
			if(isNumber) {
				try {
					for(FondiSviluppoPuglia obj : listaInput) {
						if(metodo.invoke(obj) instanceof Double) {
							Double temp = (Double)metodo.invoke(obj);
							if(temp.compareTo(datoDouble1) > 0) {
								listaOutput.add(obj);
							}
						}
					}
				}
				catch(IllegalAccessException e) {
					e.printStackTrace();
				}
				catch(InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		//Conditional operator $lt
	    //La lista in output contiene tutti i valori minori del valore di riferimento
		if(modelloFiltro.equals("$lt")) {
			if(isNumber) {
				try {
					for(FondiSviluppoPuglia obj : listaInput) {
						if(metodo.invoke(obj) instanceof Double) {
							Double temp = (Double)metodo.invoke(obj);
							if(temp.compareTo(datoDouble1) < 0) {
								listaOutput.add(obj);
							}
						}
					}
				}
				catch(IllegalAccessException e) {
					e.printStackTrace();
				}
				catch(InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		
		return listaOutput;	
	}
	
	
	
	/**
	 * 
	 * @return true (filtro esiste) oppure false (non esiste)
	 */
	public boolean isExist() {
		
		if(modelloFiltro.equals("$or") || modelloFiltro.equals("$not") || modelloFiltro.equals("$gt") || modelloFiltro.equals("$lt"))
			return true;
		else
			return false;
		
	}
}