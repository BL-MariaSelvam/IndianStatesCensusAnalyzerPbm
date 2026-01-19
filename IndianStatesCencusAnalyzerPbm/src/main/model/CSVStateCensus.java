package main.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVStateCensus {

    public Iterator<StateCensus> loadCSVData(String csvFilePath) throws Exception {

        List<StateCensus> censusList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
        String line;

        // Skip header
        reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");

            StateCensus census = new StateCensus(
                    data[0].trim(),
                    Integer.parseInt(data[1].trim()),
                    Integer.parseInt(data[2].trim()),
                    Integer.parseInt(data[3].trim())
            );
            censusList.add(census);
        }

        reader.close();
        return censusList.iterator();
    }
}

