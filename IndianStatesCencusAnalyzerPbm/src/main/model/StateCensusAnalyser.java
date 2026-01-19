package main.model;

import java.util.Iterator;

public class StateCensusAnalyser {

    private int recordCount = 0;

    public int loadIndianStateCensusData(String csvFilePath) throws Exception {

        CSVStateCensus csvLoader = new CSVStateCensus();
        Iterator<StateCensus> censusIterator = csvLoader.loadCSVData(csvFilePath);

        recordCount = 0;
        while (censusIterator.hasNext()) {
            censusIterator.next();
            recordCount++;
        }

        return recordCount;
    }
}
