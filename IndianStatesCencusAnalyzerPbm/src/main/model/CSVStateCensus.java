package main.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.CensusAnalyserException;

public class CSVStateCensus {

    public Iterator<StateCensus> loadCSVData(String csvFilePath)
            throws CensusAnalyserException {

        // File type validation (Sad Case trigger)
        if (!csvFilePath.endsWith(".csv")) {
            throw new CensusAnalyserException(
                    "Incorrect file type",
                    CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE);
        }

        List<StateCensus> censusList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {

            reader.readLine(); // skip header
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                StateCensus census = new StateCensus(
                        data[0],
                        Integer.parseInt(data[1]),
                        Integer.parseInt(data[2]),
                        Integer.parseInt(data[3])
                );
                censusList.add(census);
            }

        } catch (IOException e) {
            throw new CensusAnalyserException(
                    "File not found",
                    CensusAnalyserException.ExceptionType.FILE_NOT_FOUND);
        }

        return censusList.iterator();
    }
}

