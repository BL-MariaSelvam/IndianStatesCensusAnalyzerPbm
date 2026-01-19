package main.test;
import org.junit.Assert;
import org.junit.Test;

import main.java.CensusAnalyserException;
import main.model.StateCensusAnalyser;

public class StateCensusAnalyserDelimiterSadTest {

    // CSV file exists but delimiter is incorrect (; instead of ,)
    private static final String WRONG_DELIMITER_FILE =
            "C:\\Users\\sathi\\OneDrive\\Desktop\\selva\\bridgelabz\\StateCencusData\\StateCensusData_WrongDelimiter.csv";

    @Test
    public void givenCorrectCSVFileButWrongDelimiter_ShouldThrowParsingException() {

        try {
            StateCensusAnalyser analyser = new StateCensusAnalyser();
            analyser.loadIndianStateCensusData(WRONG_DELIMITER_FILE);
            Assert.fail("Expected CensusAnalyserException was not thrown");

        } catch (CensusAnalyserException e) {
            Assert.assertEquals(
                    CensusAnalyserException.ExceptionType.CSV_PARSING_ERROR,
                    e.type);
        }
    }
}

