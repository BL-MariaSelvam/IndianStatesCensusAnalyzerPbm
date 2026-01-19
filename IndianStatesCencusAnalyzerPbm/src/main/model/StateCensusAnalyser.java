package main.model;

import java.util.Iterator;

import main.java.CensusAnalyserException;

public class StateCensusAnalyser {

	 public int loadIndianStateCensusData(String csvFilePath)
	            throws CensusAnalyserException {

	        CSVStateCensus csvLoader = new CSVStateCensus();
	        Iterator<StateCensus> iterator = csvLoader.loadCSVData(csvFilePath);

	        int recordCount = 0;
	        while (iterator.hasNext()) {
	            iterator.next();
	            recordCount++;
	        }
	        return recordCount;
	    }
}
