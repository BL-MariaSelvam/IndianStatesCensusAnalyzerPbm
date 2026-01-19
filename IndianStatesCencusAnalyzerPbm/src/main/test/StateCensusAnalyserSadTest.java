package main.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.java.CensusAnalyserException;
import main.model.StateCensusAnalyser;

public class StateCensusAnalyserSadTest {
	// File exists but extension is incorrect
    private static final String INCORRECT_FILE_TYPE ="src/test/resources/StateCensusData.txt";

    @Test
    public void givenCorrectFilePathButIncorrectType_ShouldThrowInvalidFileTypeException() {

        try {
            StateCensusAnalyser analyser = new StateCensusAnalyser();
            analyser.loadIndianStateCensusData(INCORRECT_FILE_TYPE);
            Assert.fail("Expected CensusAnalyserException was not thrown");

        } catch (CensusAnalyserException e) {
            // Validate exception type
            Assert.assertEquals(
                    CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE,
                    e.type);
        }
    }
}
