package main.java;

import main.model.StateCensusAnalyser;

public class CencusAnalyserMain {

	public static void main(String[] args) {
		System.out.println("Indian States Cencus Analyzer");
		
		 try {
	            String csvFilePath = "C:\\Users\\sathi\\OneDrive\\Desktop\\selva\\bridgelabz\\StateCencusData\\StateCensusData.csv";

	            StateCensusAnalyser analyser = new StateCensusAnalyser();
	            int records = analyser.loadIndianStateCensusData(csvFilePath);

	            System.out.println("Number of Census Records: " + records);

	            // Example validation
	            if (records == 2) {
	                System.out.println("Record count matched!");
	            } else {
	                System.out.println("Record count mismatch!");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	}

}
