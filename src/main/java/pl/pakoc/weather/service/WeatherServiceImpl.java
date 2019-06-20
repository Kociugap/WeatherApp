package pl.pakoc.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pl.pakoc.weather.domain.Response;

@Service
public class WeatherServiceImpl implements WeatherService {
	
	@Value("${api.weather.url}")
	private String url;
	@Value("${api.weather.city}")
	private String city;
	@Value("${api.weather.key}")
	private String appid;
	
	private RestTemplate restTemplate;
	
	@Autowired
	public WeatherServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public Response getWeatherByCountry() {

		Response response = restTemplate.getForObject(url, Response.class, appid, city);
		return response;
		
	}
	

}
