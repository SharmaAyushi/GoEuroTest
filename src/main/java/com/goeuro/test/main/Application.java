package com.goeuro.test.main;

/**
 * Entry point for this application. 
 * Main method accepts the city name as command line argument and does further processing. 
 * Spring is used rigorously throughout the application for dependency injection, reading properties file, calling web service etc.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.goeuro.test.client.GoEuroClient;
import com.goeuro.test.common.contants.ErrorMessageConstants;
import com.goeuro.test.common.helper.Helper;
import com.goeuro.test.entity.City;
import com.goeuro.test.writer.csv.CSVFileWriter;

@SpringBootApplication
@ComponentScan("com.goeuro.test")
@PropertySource("classpath:config.properties")
public class Application implements CommandLineRunner {

	@Autowired
	private GoEuroClient goEuroClient;

	@Value("${client.url}")
	private String url;

	public static void main(String args[]) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... strings) throws Exception {
		getCities(strings);
	}

	private void getCities(String... strings) {
		//Display error message if city name is not provided and exit.
		if (strings.length < 1) {
			Helper.displayErrorMessageAndExit(ErrorMessageConstants.EMPTY_CITY_NAME);
		}

		String cityName = strings[0];
		if(url.trim().isEmpty()){
			Helper.displayErrorMessageAndExit(ErrorMessageConstants.EMPTY_URL);
		}
		City[] cities = goEuroClient.getCities(url, cityName);
		CSVFileWriter.writeToCsvFile(cityName + ".csv", cities);
	}

}
