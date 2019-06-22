package com.example.JavaProject.SviluppoDati;

import java.io.*;
import java.util.*;
import java.lang.reflect.Field;

/**
 * Classe che si occupa del Parsing e della Serializzazione dei metadati.
 */
public class ParsingAndSerializationMetadata {
	
	/**
	 * Metodo static che si occupa del Parsing dei metadati degli attributi della classe FondiSviluppoPuglia.
	 * 
	 * @return Vector di oggetti di tipo Metadata
	 */
	public static Vector<Metadata> getMetadata() {
		Vector<Metadata> v = new Vector<Metadata>();
		Class<?> c = FondiSviluppoPuglia.class;
		Field[] attributes = c.getDeclaredFields();			
		for(int i=0; i<attributes.length; i++) {
			Metadati annotation = attributes[i].getAnnotation(Metadati.class);
			v.add(new Metadata(annotation.nome(), annotation.tipo()));
		}		
		return v;
	}
	
	/**
	 * Metodo static che si occupa della serializzazione dei metadati dal Vector di oggetti di tipo Metadata.
	 * 
	 * @param file		File su cui vengono serializzati i metadati
	 * @param metadata	Vector di Metadata da dove vengono presi i metadati
	 */
	public static void SerializationMetadata(File file, Vector<Metadata> metadata) {
		   try {
			   ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			   output.writeObject(metadata);
			   output.close();
		  } catch(IOException e) {
			  System.out.println("Error of I/O");
			  e.printStackTrace();
		  }
	}
	
}
