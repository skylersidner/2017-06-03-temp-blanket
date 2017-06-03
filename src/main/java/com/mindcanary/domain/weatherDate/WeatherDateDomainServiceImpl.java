package com.mindcanary.domain.weatherDate;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.mindcanary.infrastructure.weatherDate.WeatherDateDaoService;

@Named
public class WeatherDateDomainServiceImpl implements WeatherDateDomainService {

	@Inject
	WeatherDateDaoService weatherDateDaoService;
	
	@Override
	public List<WeatherDate> getLastYear() {
		List<WeatherDate> weatherDates = weatherDateDaoService.getLastYear();
	    return weatherDates;
	}

}
