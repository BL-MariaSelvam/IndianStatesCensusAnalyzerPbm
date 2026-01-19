package main.model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import main.java.CensusAnalyserException;

public class CSVStateCensus {

    private static final String EXPECTED_HEADER =
            "State,Population,AreaInSqKm,DensityPerSqKm";

    public Iterator<StateCensus> loadCSVData(String csvFilePath)
            throws CensusAnalyserException {

        // File type validation
        if (!csvFilePath.endsWith(".csv")) {
            throw new CensusAnalyserException(
                    "Invalid file type",
                    CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE);
        }

        List<StateCensus> censusList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {

            String header = reader.readLine();

            // Header validation (Sad Case trigger)
            if (!EXPECTED_HEADER.equals(header)) {
                throw new CensusAnalyserException(
                        "Incorrect CSV header",
                        CensusAnalyserException.ExceptionType.CSV_HEADER_ERROR);
            }

            String line;
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length != 4) {
                    throw new CensusAnalyserException(
                            "CSV parsing error",
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
