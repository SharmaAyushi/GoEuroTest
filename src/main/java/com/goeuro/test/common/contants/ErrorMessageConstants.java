package com.goeuro.test.common.contants;

/**
 * Constants file to hold the error messages to be used throughout the
 * application. The class will contain only static fields. Hence, the class is
 * declared as final with a private constructor.
 * 
 * @author Ayushi
 *
 */
public final class ErrorMessageConstants {

	private ErrorMessageConstants() {
	};

	public static final String ERROR_URL = "Error while accessing the URL ";
	public static final String EMPTY_URL = "No url specified in config.properties file.";
	public static final String EMPTY_CITY_NAME = "Please provide a city name.";
	public static final String NO_MATCH_FOUND = "No match found for the city :";
	public static final String ERROR_CREATING_FILE = "Error while creating csv file %s. Please check if the file is already in use or if you have write permission.";
	public static final String ERROR_WRITING_FILE = "Error while writing to file ";
	public static final String ERROR_CLOSING_FILE = "Error while flushing/closing fileWriter !!!";
}
