package com.example.JavaProject.SviluppoDati;

import java.io.*;
import java.util.*;

public class ParsingAndSerializationData {
	public static Vector<FondiSviluppoPuglia> getData() {
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
			System.out.println(v.toString());
		}
		return v;
	}
	
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







