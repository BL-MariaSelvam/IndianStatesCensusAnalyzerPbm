package main.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.java.CensusAnalyserException;
import main.model.StateCensusAnalyser;

public class StateCensusAnalyserTest {
	
	 private static final String STATE_CENSUS_CSV_FILE = "C:\\Users\\sathi\\OneDrive\\Desktop\\selva\\bridgelabz\\StateCencusData\\StateCensusData.csv";
	 private static final String WRONG_CSV_FILE = "StateCensusData.txt";

	    @Test
	    public void givenStateCensusCSVFile_WhenLoaded_ShouldReturnCorrectRecordCount() {
	        try {
	            // Arrange
	            StateCensusAnalyser analyser = new StateCensusAnalyser();
	            int expectedRecordCount = 2;

	            // Act
	            int actualRecordCount =
	                    analyser.loadIndianStateCensusData(STATE_CENSUS_CSV_FILE);

	            // Assert (Happy Test Case)
	            Assert.assertEquals(expectedRecordCount, actualRecordCount);

	        } catch (Exception e) {
	            Assert.fail("Exception should not be thrown for valid CSV file");
	        }
	    }

	    
	    @Test
	    public void givenIncorrectFileType_WhenLoaded_ShouldThrowCustomException() {
	        try {
	            StateCensusAnalyser analyser = new StateCensusAnalyser();
	            analyser.loadIndianStateCensusData(WRONG_CSV_FILE);
	            Assert.fail("Expected CensusAnalyserException was not thrown");
	        } catch (CensusAnalyserException e) {
	            Assert.assertEquals(
	                    CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE,
	                    e.type);
	        }
	    }
}
