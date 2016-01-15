package com.goeuro.test.entity;

/**
 * Domain class for city
 * @author Ayushi
 *
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class City {

	@JsonProperty("_id")
	private String id;

	@JsonProperty("key")
	private String key;

	@JsonProperty("name")
	private String name;

	@JsonProperty("fullName")
	private String fullName;

	@JsonProperty("iata_airport_code")
	private String iataAirportCode;

	@JsonProperty("type")
	private String type;

	@JsonProperty("country")
	private String country;

	@JsonProperty("locationId")
	private String locationId;

	@JsonProperty("inEurope")
	private String inEurope;

	@JsonProperty("countryCode")
	private String countryCode;

	@JsonProperty("coreCountry")
	private String coreCountry;

	@JsonProperty("distance")
	private String distance;

	@JsonProperty("geo_position")
	private GeoPosition geoPosition;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIataAirportCode() {
		return iataAirportCode;
	}

	public void setIataAirportCode(String iataAirportCode) {
		this.iataAirportCode = iataAirportCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getInEurope() {
		return inEurope;
	}

	public void setInEurope(String inEurope) {
		this.inEurope = inEurope;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCoreCountry() {
		return coreCountry;
	}

	public void setCoreCountry(String coreCountry) {
		this.coreCountry = coreCountry;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public GeoPosition getGeoPosition() {
		return geoPosition;
	}

	public void setGeoPosition(GeoPosition geoPosition) {
		this.geoPosition = geoPosition;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", key=" + key + ", name=" + name + ", fullName=" + fullName + ", iataAirportCode=" + iataAirportCode + ", type=" + type + ", country=" + country
				+ ", locationId=" + locationId + ", inEurope=" + inEurope + ", countryCode=" + countryCode + ", coreCountry=" + coreCountry + ", distance=" + distance
				+ ", geoPosition=" + geoPosition + "]";
	}

}
