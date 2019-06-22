package com.example.JavaProject.SviluppoDati;

import java.io.*;
import java.util.*;

/**
 * Classe che si occupa della lettura dei dati e dei metadati.
 */
public class Reading {
	
	/**
	 * Metodo static che legge dal file preso come parametro in ingresso gli oggetti di tipo FondiSviluppoPuglia.
	 * 
	 * @param file	File da cui vengono letti gli oggetti di tipo FondiSviluppoPuglia
	 * 
	 * @return Vector di oggetti di tipo FondiSviluppoPuglia
	 */
	public static Vector<FondiSviluppoPuglia> ReadingData(File file){
		Vector<FondiSviluppoPuglia> v = new Vector<FondiSviluppoPuglia>();
		try {
			ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			v = (Vector<FondiSviluppoPuglia>)input.readObject();
			input.close();
		} catch(ClassNotFoundException e) {
			System.out.println("List Not Found");
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println("Error of I/O");
			e.printStackTrace();
		}
		return v;
	}
	
	/**
	 * Metodo static che legge dal file preso come parametro in ingresso gli oggetti di tipo Metadata.
	 * 
	 * @param file	File da cui vengono letti gli oggetti di tipo Metadata
	 * 
	 * @return Vector di oggetti di tipo Metadata
	 */
	public static Vector<Metadata> ReadingMetadata(File file){
		Vector<Metadata> v = new Vector<Metadata>();   
		try {
			ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			v = (Vector<Metadata>)input.readObject();
			input.close();
		} catch(ClassNotFoundException e) {
			System.out.println("List Not Found");
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println("Error of I/O");
			e.printStackTrace();
		}
		return v;
	}
	
}
