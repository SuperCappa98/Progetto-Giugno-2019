package com.example.JavaProject.SviluppoDati;

import java.io.*;
import java.util.*;
import java.lang.reflect.Field;


public class ParsingAndSerializationMetadata {
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
