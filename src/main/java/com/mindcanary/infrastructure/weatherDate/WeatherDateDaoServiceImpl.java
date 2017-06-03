package com.mindcanary.infrastructure.weatherDate;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.mindcanary.domain.weatherDate.WeatherDate;
import com.mindcanary.utils.MockWeatherDateGenerator;

@Named
public class WeatherDateDaoServiceImpl implements WeatherDateDaoService {
	
	@Inject
	MockWeatherDateGenerator mockWeatherDateGenerator;

	@Override
	public List<WeatherDate> getLastYear() {
	    List<WeatherDate> weatherDates = mockWeatherDateGenerator.get365RealisticWeatherDates();
	    
	    return weatherDates;
	}

}
