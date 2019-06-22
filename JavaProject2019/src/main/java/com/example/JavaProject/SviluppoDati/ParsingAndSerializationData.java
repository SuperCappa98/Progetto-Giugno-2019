package com.example.JavaProject.SviluppoDati;

import java.io.*;
import java.util.*;

/**
 * Classe che si occupa del Parsing e della Serializzazione dei dati.
 */
public class ParsingAndSerializationData {
	
	/**
	 * Metodo static che si occupa del Parsing dei dati a partire dal file letto.
	 * 
	 * @return Vector di oggetti di tipo FondiSviluppoPuglia
	 */
	public static Vector<FondiSviluppoPuglia> getData() {
		/* 
		 * Il delimitatore usato è rappresentato da una virgola racchiusa tra virgolette
		 * così da non provocare errori visto la presenza di diversi numeri con la virgola
		 * al posto del punto. Inoltre per fare il parsing di tali numeri con la virgola o
		 * gli eventuali n.d. è stato utilizzato il metodo replace della classe String per
		 * rimpiazzare le prime con i punti e i secondi con il valore 0.
		 */
		String DELIMITER = "\",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)\"";
		Vector<FondiSviluppoPuglia> v = new Vector<FondiSviluppoPuglia>();
		try (BufferedReader br = new BufferedReader(new FileReader("data-set.csv"))) {
			String line;
			int iteration = 0;
			while ((line = br.readLine()) != null) {
				if(iteration==0) {
					iteration++;
					continue;
				}
				String[] values = line.split(DELIMITER);
				System.out.println("The array's length is " + values.length);
				for (int i = 6; i<9; i++) {
					values[i] = values[i].replace(',', '.').replace("n.d.", "0");
					
				}
				v.add(new FondiSviluppoPuglia(values[0], values[1], values[2], values[3], values[4], values[5], Double.parseDouble(values[6]),
						Double.parseDouble(values[7]), Double.parseDouble(values[8]), values[9], values[10], values[11], values[12], values[13],
						values[14], values[15]));
			}
			br.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
		for(FondiSviluppoPuglia item: v) {		
			System.out.println(v.toString());	//stampa i vari oggetti della classe FondiSviluppoPuglia tramite un for each dopo aver fatto il parsing e averli inseriti in un vettore
		}
		return v;
	}
	
	/**
	 * Metodo static che si occupa della serializzazione dei dati dal Vector di oggetti di tipo FondiSviluppoPuglia.
	 * 
	 * @param file	File su cui vengono serializzati gli oggetti
	 * @param data	Vector di FondiSviluppoPuglia da dove vengono presi i dati
	 */
	public static void SerializationData(File file, Vector<FondiSviluppoPuglia> data) {
		   try {			   
			   ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			   output.writeObject(data);
			   output.close();
		   } catch(IOException e) {
			   System.out.println("Error of I/O");
			   e.printStackTrace();
		   }
	}
	
}







