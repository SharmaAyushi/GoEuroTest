package com.goeuro.test.writer.csv;

/**
 * Writer class that will write contect to a csv file.
 */
import java.io.FileWriter;
import java.io.IOException;

import com.goeuro.test.common.contants.ErrorMessageConstants;
import com.goeuro.test.common.helper.Helper;
import com.goeuro.test.entity.City;

public class CSVFileWriter {
	private static final String COMMA_DELIMITER = ",";
	private static final String SPACE_DELIMITER = " ";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String FILE_HEADER = "_id, name, type, latitude, longitude";

	/**
	 * Accepts file name and creates a file with the given name at the current
	 * location. The file name is same as the city name provided by the user.
	 * For eg, if user gives the city name as Tokyo, a csv file with the name
	 * Tokyo.csv is created at the current location. Also accepts the data
	 * returned by the web service. Writes the _id, name, type, latitude,
	 * longitude corresponding to each record into the file.
	 * 
	 * Displays error message in case the file is already in use or the logged
	 * in user doesn't have write permission on the current path. Also displays
	 * error message if there's an error while writing to a file or closing the
	 * file writer.
	 * 
	 * @param fileName
	 * @param cities
	 */
	public static void writeToCsvFile(String fileName, City[] cities) {
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(fileName);
		} catch (IOException exception) {
			Helper.displayErrorMessageAndExit(String.format(ErrorMessageConstants.ERROR_CREATING_FILE, fileName));
		}
		try {
			fileWriter.append(FILE_HEADER.toString());
			fileWriter.append(NEW_LINE_SEPARATOR);

			for (City city : cities) {
				fileWriter.append(city.getId());
				fileWriter.append(COMMA_DELIMITER).append(SPACE_DELIMITER);
				fileWriter.append(city.getName());
				fileWriter.append(COMMA_DELIMITER).append(SPACE_DELIMITER);
				fileWriter.append(city.getType());
				fileWriter.append(COMMA_DELIMITER).append(SPACE_DELIMITER);
				fileWriter.append(city.getGeoPosition().getLatitude());
				fileWriter.append(COMMA_DELIMITER).append(SPACE_DELIMITER);
				fileWriter.append(city.getGeoPosition().getLongitude());
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
		} catch (IOException exception) {
			Helper.displayErrorMessageAndExit(ErrorMessageConstants.ERROR_WRITING_FILE.concat(fileName));
		}

		System.out.println(fileName.concat(" file created successfully !!!"));

		try {
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			Helper.displayErrorMessageAndExit(ErrorMessageConstants.ERROR_CLOSING_FILE);
		}

	}

}
