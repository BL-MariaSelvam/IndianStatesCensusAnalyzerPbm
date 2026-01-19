package main.model;

import java.util.Iterator;

import main.java.CensusAnalyserException;

public class StateCensusAnalyser {

	 public int loadIndianStateCensusData(String csvFilePath)
	            throws CensusAnalyserException {

	        CSVStateCensus loader = new CSVStateCensus();
	        Iterator<StateCensus> iterator = loader.loadCSVData(csvFilePath);

	        int count = 0;
	        while (iterator.hasNext()) {
	            iterator.next();
	            count++;
	        }
	        return count;
	    }
}
