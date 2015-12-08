package edu.sdju.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadWriteCVS {

	/*
  public static void main(String[] args) {

	ReadWriteCVS obj = new ReadWriteCVS();
	obj.run();

  }
*/
  public String run() {

	String csvFile = "D:\\Documents\\p2p\\训练数据\\平台44.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
	String result = "";

	try {

		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {

		        // use comma as separator
			String[] country = line.split(cvsSplitBy);

			//result += "Country [code= " + country[27] + " , name=" + country[27] + "]"
			for (String s : country) {
				result += s;
			}

		}

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	System.out.println("Done");
	return result;
  }

}
