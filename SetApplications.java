package com.ds.applications;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SetApplications {

	public static int findImportantParagraph(String FilePath) {
		int para = 1;
		int dwords = 0, res = 0, resp = 0;
		try {
			FileReader f = new FileReader(FilePath);
			BufferedReader br = new BufferedReader(f);
			HashMap<String, Integer> h = new HashMap<String, Integer>();
			String line;
			while ((line = br.readLine()) != null) {
				
				if (line.trim().length() == 0) {
					if (dwords > res) {
						res = dwords;
						resp = para;
					}
					++para;
					dwords = 0;
					continue;

				}
				StringTokenizer st = new StringTokenizer(line);

				while (st.hasMoreTokens()) {
					String word = st.nextToken();

					if (h.containsKey(word) == false
							|| !(h.get(word).equals(para))) {
						h.put(word, para);
						++dwords;
					}
				}
			}
			if (dwords > res) {
				res = dwords;
				resp = para;
			}

		} catch (FileNotFoundException e) {
			System.out.println("File Not found: " + FilePath);
		} catch (IOException e) {
			System.out.println("IOException errored");
		}

		return resp;
	}
	public static void main(String args[])
	{
		System.out.println(findImportantParagraph(new String("C:\\input.txt")));
	}
	
}
