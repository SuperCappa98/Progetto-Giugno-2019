package com.example.JavaProject.SviluppoDati;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.*;

public class ParsingAndSerializationMetadata {
	public static void main(String[] args) {
		ArrayList<Metadata> listMetadata = new ArrayList<Metadata>();
		Class<?> c = FondiSviluppoPuglia.class;
		Field[] attributo = c.getDeclaredFields();
		for(int i=0; i<attributo.length; i++) {
			Metadati annotazione = attributo[i].getAnnotation(Metadati.class);
			listMetadata.add(new Metadata(annotazione.nome(),annotazione.tipo()));
		}
		
		File fileMetadata = new File ("file metadata.dat");
		try {
			fileMetadata.createNewFile();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileMetadata)));
			output.writeObject(listMetadata);
			output.close();
		} catch(IOException e) {
			System.out.println("Errore di I/O");
			e.printStackTrace();
		}
	}

}
