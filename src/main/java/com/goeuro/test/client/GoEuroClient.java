package com.goeuro.test.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.goeuro.test.common.contants.ErrorMessageConstants;
import com.goeuro.test.common.helper.Helper;
import com.goeuro.test.entity.City;

@Component
public class GoEuroClient {

	private RestTemplate restTemplate;

	/**
	 * Accepts url of the web service to be called. Calls the web service with
	 * the city name as provided by the user. Displays error message if url is
	 * invalid or no match is found for the given city.
	 * Utilizes org.springframework.web.client.RestTemplate to call the service. 
	 * 
	 * @param url
	 *            : URL of the web service to be called
	 * @param cityName
	 *            : City name provided by the user.
	 * @return
	 */
	public City[] getCities(String url, String cityName) {
		City[] cities = null;

		try {
			cities = getRestTemplate().getForObject(url.concat(cityName), City[].class);
		} catch (HttpClientErrorException hce) {
			Helper.displayErrorMessageAndExit(ErrorMessageConstants.ERROR_URL.concat(url));
		}
		if (cities == null || cities.length < 1) {
			Helper.displayErrorMessageAndExit(ErrorMessageConstants.NO_MATCH_FOUND.concat(cityName));
		}

		return cities;
	}

	private RestTemplate getRestTemplate() {
		if (restTemplate == null) {
			restTemplate = new RestTemplate();
		}
		return restTemplate;
	}
}
