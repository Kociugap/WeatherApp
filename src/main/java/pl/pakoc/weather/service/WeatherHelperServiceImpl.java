package pl.pakoc.weather.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.annotation.PostConstruct;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import pl.pakoc.weather.domain.Response;

@Service
public class WeatherHelperServiceImpl implements WeatherHelperService {
	
	@Value("${file}")
	private String file;
	
	private Logger logger = Logger.getLogger(WeatherHelperServiceImpl.class);
	
	private WeatherService weatherService;
	
	@Autowired
	public WeatherHelperServiceImpl(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@PostConstruct
	@Override
	public void writeFirst() {
		
		Response response = weatherService.getWeatherByCountry();
		
		writeWeatherToFile(response.buildFirstLine());
		writeWeatherToFile(response.toString());
		
	}

	@Override
	public void writeWeatherToFile(String response) {
		
		try {
			Files.write(Paths.get(file), response.getBytes(), StandardOpenOption.APPEND);
			Files.write(Paths.get(file), System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		
	}

}
