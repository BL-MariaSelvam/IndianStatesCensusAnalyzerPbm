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

        List<StateCensus> censusList = new ArrayList<>();

        // Validate file type
        if (!csvFilePath.endsWith(".csv")) {
            throw new CensusAnalyserException(
                    "Invalid file type",
                    CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {

            String line;
            reader.readLine(); // Skip header

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length != 4) {
                    throw new CensusAnalyserException(
                            "Invalid CSV format",
                            CensusAnalyserException.ExceptionType.CSV_PARSING_ERROR);
                }

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
        } catch (NumberFormatException e) {
            throw new CensusAnalyserException(
                    "CSV parsing error",
                    CensusAnalyserException.ExceptionType.CSV_PARSING_ERROR);
        }

        return censusList.iterator();
    }
}
