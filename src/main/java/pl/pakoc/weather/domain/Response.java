package pl.pakoc.weather.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Response {
	
	private Main main;
	private Wind wind;
	private Sys sys;
	private String name;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public Sys getSys() {
		return sys;
	}
	public void setSys(Sys sys) {
		this.sys = sys;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.append(LocalDateTime.now().format(formatter)).append(" ")
		.append(this.getMain().getTemp()).append(" ")
		.append(this.getMain().getHumidity()).append(" ")
		.append(this.getMain().getPressure()).append(" ")
		.append(this.getWind().getSpeed()).toString();
	}
	
	public String buildFirstLine() {
		StringBuilder sb = new StringBuilder();
		return sb.append(this.getName()).append(" ").
		append(this.getSys().getSunrise()).append(" ").
		append(this.getSys().getSunset()).toString();
	}
	
}
