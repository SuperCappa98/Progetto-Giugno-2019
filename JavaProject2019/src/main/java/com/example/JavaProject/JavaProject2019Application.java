package com.example.JavaProject;

import java.io.*;
import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.JavaProject.SviluppoDati.*;

@SpringBootApplication
public class JavaProject2019Application {

	public static void main(String[] args) {
		//Download del file CSV
		DownloadCSV.main(args);
		
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



