package com.example.JavaProject.SviluppoDati;

import java.io.*;
import java.util.*;

public class ParsingAndSerializationData {
	final static String COMMA_DELIMITER = ",";

	public static void main(String[] args) {
		List<List<String>> records = new ArrayList<>();
		Vector<FondiSviluppoPuglia> v = new Vector<FondiSviluppoPuglia>();
		try (BufferedReader br = new BufferedReader(new FileReader("data-set.csv"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(COMMA_DELIMITER);
				System.out.println(values.length);
				records.add(Arrays.asList(values));
				v.add(new FondiSviluppoPuglia(values[0], values[1], values[2], values[3], values[4], values[5], Double.parseDouble(values[6]),
						Double.parseDouble(values[7]), Double.parseDouble(values[8]), values[9], values[10], values[11], values[12], values[13],
						Long.parseLong(values[14]), values[15]));
			}
			br.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		}
		for(FondiSviluppoPuglia item: v) {		
			System.out.println(v.toString());
		}
	}
}


