package com.example.JavaProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.JavaProject.SviluppoDati.*;

@SpringBootApplication
public class JavaProject2019Application {

	public static void main(String[] args) {
		//Download del file CSV
		DownloadCSV.main(args);
		
		//Parsing e serializzazione dei dati
		ArrayList<FondiSviluppoPuglia> dati = ParsingAndSerializationData.getData();;
		
		//Parsing e serializzazione dei metadati
		ParsingAndSerializationMetadata.main(args);
		
		//Avvio di Spring
		SpringApplication.run(JavaProject2019Application.class, args);
	}

}



