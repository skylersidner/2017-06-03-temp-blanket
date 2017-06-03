package com.mindcanary.infrastructure.weatherDate;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.mindcanary.domain.weatherDate.WeatherDate;
import com.mindcanary.utils.MockWeatherDateGeneratorService;

@Named
public class WeatherDateDaoServiceImpl implements WeatherDateDaoService {
	
	@Inject
	MockWeatherDateGeneratorService mockWeatherDateGenerator;

	@Override
	public List<WeatherDate> getLastYear() {
	    List<WeatherDate> weatherDates = mockWeatherDateGenerator.get365RealisticWeatherDates();
	    
	    return weatherDates;
	}

}
