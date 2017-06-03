package com.mindcanary.utils;

import java.util.List;

import com.mindcanary.domain.weatherDate.WeatherDate;

public interface MockWeatherDateGenerator {

	public List<WeatherDate> get365RandomWeatherDates();
	
	public List<WeatherDate> get365RealisticWeatherDates();
}
