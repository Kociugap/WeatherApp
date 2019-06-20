package pl.pakoc.weather.domain;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Sys {
	
	private long sunrise;
	private long sunset;
	
	public String getSunrise() {
		 return LocalDateTime.ofInstant(Instant.ofEpochMilli(sunrise * 1000), ZoneId.systemDefault()).toLocalTime().toString();
	}
	public void setSunrise(long sunrise) {
		this.sunrise = sunrise;
	}
	public String getSunset() {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(sunset * 1000), ZoneId.systemDefault()).toLocalTime().toString();
	}
	public void setSunset(long sunset) {
		this.sunset = sunset;
	}
	
	

}
