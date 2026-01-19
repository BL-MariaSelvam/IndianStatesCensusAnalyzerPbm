package main.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.model.StateCensusAnalyser;

public class StateCensusAnalyserTest {
	
	 private static final String STATE_CENSUS_CSV_FILE = "C:\\Users\\sathi\\OneDrive\\Desktop\\selva\\bridgelabz\\StateCencusData\\StateCensusData.csv";

	    @Test
	    public void givenStateCensusCSVFile_WhenLoaded_ShouldReturnCorrectRecordCount() {
	        try {
	            // Arrange
	            StateCensusAnalyser analyser = new StateCensusAnalyser();
	            int expectedRecordCount = 29;

	            // Act
	            int actualRecordCount =
	                    analyser.loadIndianStateCensusData(STATE_CENSUS_CSV_FILE);

	            // Assert (Happy Test Case)
	            Assert.assertEquals(expectedRecordCount, actualRecordCount);

	        } catch (Exception e) {
	            Assert.fail("Exception should not be thrown for valid CSV file");
	        }
	    }

}
