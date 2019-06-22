package com.example.JavaProject;

import java.io.*;
import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.JavaProject.SviluppoDati.*;

@SpringBootApplication
public class JavaProject2019Application {
	
	/**
	 * Metodo static principale dell'applicazione da cui vengono richiamati i metodi necessari
	 * al download del file .csv, al parsing e alla serializzazione dei dati e dei matadati dalle
	 * dalle relative classi. Inoltre lancia l'applicazione con Spring. 
	 */
	public static void main(String[] args) {
		
		//Download del file CSV
		DownloadCSV.ScanURL();
		
		//Parsing e serializzazione dei dati
		Vector<FondiSviluppoPuglia> data = ParsingAndSerializationData.getData();
		File fileData = new File("data file.dat");
		try{
			fileData.createNewFile();
		} catch(IOException e) {
			e.printStackTrace();
		}
		ParsingAndSerializationData.SerializationData(fileData, data); 
		
		//Parsing e serializzazione dei metadati
		Vector<Metadata> metadata = ParsingAndSerializationMetadata.getMetadata();
		File fileMetadata = new File("metadata file.dat");
		try {
			fileMetadata.createNewFile();
		} catch(IOException e) {
			e.printStackTrace();
		}
		ParsingAndSerializationMetadata.SerializationMetadata(fileMetadata, metadata);	
		
		//Avvio di Spring
		SpringApplication.run(JavaProject2019Application.class, args);
	}

}



