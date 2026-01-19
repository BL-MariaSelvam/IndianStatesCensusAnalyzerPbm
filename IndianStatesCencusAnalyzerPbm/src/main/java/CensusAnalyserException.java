package main.java;

public class CensusAnalyserException extends Exception {

    public enum ExceptionType {
        FILE_NOT_FOUND,
        INVALID_FILE_TYPE,
        CSV_PARSING_ERROR,
        CSV_HEADER_ERROR
    }

    public ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}

