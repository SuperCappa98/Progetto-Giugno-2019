package com.example.JavaProject;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import com.example.JavaProject.SviluppoDati.*;

import org.springframework.web.bind.annotation.*;

/**
 * Classe Controller per gestire le varie funzionalità API REST fornite da Spring Boot.<br>
 * In particolare la seguente classe implementa i metodi di richiesta dei metadati, dei 
 * dati e delle statistiche, eventualmente con i filtri specificati.
 */
@RestController
public class Controller {
	
	/**
	 * Metodo per la richiesta tramite GET dei metadati.
	 * 
	 * @return metadati in formato JSON 
	 */
	@RequestMapping(value="/metadata", method=RequestMethod.GET)
	public Vector<Metadata> MetadataRequest(){
		return Reading.ReadingMetadata(new File("metadata file.dat"));
	}
	
	/**
	 * Metodo per la richiesta tramite GET dei dati secondo l'eventuale filtro specificato.
	 * 
	 * @param filter 	Filtro specificato nella richiesta, se presente
	 * @param attribute Attributo su cui viene applicato il filtro ai dati
	 * @param value1	Valore primario utilizzato nel filtraggio
	 * @param value2	Valore secondario utilizzato nel filtraggio (solo per gli operatori $or e $bt)
	 * 
	 * @return dati in formato JSON o eventuali messaggi di errore
	 */
	@RequestMapping(value="/data", method = RequestMethod.GET)
	public Object DataRequest(@RequestParam(value = "filter", defaultValue = "vuoto")String filter, @RequestParam(value = "attribute", defaultValue = "vuoto")String attribute, String value1,@RequestParam(value="value2", defaultValue = "0") String value2){
		Vector<FondiSviluppoPuglia> v = Reading.ReadingData(new File("data file.dat"));
		if(attribute.equals("vuoto")) {
			return v;
		}
		else {
			Vector<Metadata> metadata = Reading.ReadingMetadata(new File("metadata file.dat"));
			boolean[] checkAttribute = new boolean[metadata.size()];
			for(int i=0; i<metadata.size(); i++) {
				if(!attribute.equals(metadata.get(i).getNome())) {
					checkAttribute[i] = true;
				}
				else {
					checkAttribute[i] = false;
				}
			}
			boolean isNotAttribute = true;
			for(int i=0; i<metadata.size(); i++) {
				isNotAttribute &= checkAttribute[i];
			}
			if(isNotAttribute) {
				return "Attributo inserito non valido";
			}
			if(filter.equals("vuoto"))
				return v;
			else {
				Filtro filtro = new Filtro(filter);
				if(!filtro.isExist())
					return "Filtro usato non esistente";
				Vector<FondiSviluppoPuglia> output = (Vector<FondiSviluppoPuglia>)filtro.Research(attribute, value1, value2, v);
				if(output.size() == 0)
					return "Nessun elemento corrisponde a questa richiesta";
				else
					return output;
			}
		}
	}
	
	/**
	 * Metodo per la richiesta tramite GET delle statistiche relative all'attributo indicato
	 * sia che esso sia di tipo numerico o di tipo String secondo l'eventuale filtro specificato.
	 * 
	 * @param filter	Filtro specificato nella richiesta, se presente
	 * @param attribute	Attributo del quale si vuole conoscere le statistiche su cui viene applicato il filtro
	 * @param value1	Valore primario utilizzato nel filtraggio
	 * @param value2	Valore secondario utilizzato nel filtraggio (solo per gli operatori $or e $bt)
	 * 
	 * @return statistiche sui dati in formato JSON o eventuali messaggi di errore
	 */
	@RequestMapping(value="/statistics", method = RequestMethod.GET)
	public Object StatisticsRequest(@RequestParam(value="filter", defaultValue = "vuoto")String filter, String attribute, String value1, @RequestParam(value = "value2", defaultValue = "0")String value2){
		Vector<Object> attributes = new Vector<Object>();
		try{
			Method metodo = FondiSviluppoPuglia.class.getMethod("get" + attribute.substring(0,1).toUpperCase() + attribute.substring(1));
			Vector<FondiSviluppoPuglia> v = Reading.ReadingData(new File("data file.dat"));
			if(filter.equals("vuoto")) {
				for(FondiSviluppoPuglia obj : v) {
					attributes.add(metodo.invoke(obj));
				}
			}
			else {
				Filtro filtro = new Filtro(filter);
				if(!filtro.isExist())
					return "Filtro usato non esistente";
				Vector<FondiSviluppoPuglia> vFiltered = (Vector<FondiSviluppoPuglia>)filtro.Research(attribute, value1, value2, v);
				for(FondiSviluppoPuglia obj : vFiltered) {
					attributes.add(metodo.invoke(obj));
				}
			}
		} catch(NoSuchMethodException e) {
			e.printStackTrace();
			return "Attributo inserito non valido";
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		} catch(InvocationTargetException e) {
			e.printStackTrace();
		}
		if(attributes.size() == 0)
			return "Nessun elemento corrisponde a questa richiesta";
		if(attributes.get(0) instanceof String) {
			 Vector<String> vString = new Vector<String>();
			  for(Object obj : attributes) {
				  String string = (String) obj;
				  vString.add(string);
			  }
			  return Statistics.getStringStatistics(vString);
		  }
		else {
			Vector<Double> vNumber = new Vector<Double>();
			for(Object number : attributes)
				vNumber.add((Double)number);
			
			return new NumStatistics(Statistics.getAvg(vNumber), Statistics.getMin(vNumber), Statistics.getMax(vNumber),
					Statistics.getDevStd(vNumber), Statistics.getSum(vNumber), vNumber.size());
		}
	}
	
}
