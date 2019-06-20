package pl.pakoc.weather.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import pl.pakoc.weather.service.WeatherHelperService;
import pl.pakoc.weather.service.WeatherService;

@Service
public class SchedulerServiceImpl implements ScheduleService {
	
	private WeatherHelperService weatherHelperService;
	private WeatherService weatherService;
	
	@Autowired
	public SchedulerServiceImpl(WeatherHelperService weatherHelperService, WeatherService weatherService) {
		this.weatherHelperService = weatherHelperService;
		this.weatherService = weatherService;
	}

	@Scheduled(fixedDelay = 3600000, initialDelay = 3600000)
	@Override
	public void checkWeather() {
		weatherHelperService.writeWeatherToFile(weatherService.getWeatherByCountry().toString());
	}

}
