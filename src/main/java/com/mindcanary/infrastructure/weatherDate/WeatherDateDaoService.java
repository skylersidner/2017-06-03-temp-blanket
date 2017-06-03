package com.mindcanary.infrastructure.weatherDate;

import java.util.List;

import com.mindcanary.domain.weatherDate.WeatherDate;

public interface WeatherDateDaoService {
	
	public List<WeatherDate> getLastYear();

}
