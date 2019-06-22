package com.example.JavaProject.SviluppoDati;

import java.io.*;
import java.util.*;

public class Reading {
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
