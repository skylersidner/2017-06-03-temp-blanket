package com.mindcanary.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Named;

import com.mindcanary.domain.type.TemperatureTrendType;
import com.mindcanary.domain.weatherDate.WeatherDate;

@Named
public class MockWeatherDateGeneratorImpl implements MockWeatherDateGenerator {
	

	public List<WeatherDate> get365RandomWeatherDates() {
		List<WeatherDate> weatherDates = new ArrayList<WeatherDate>();
	    
	    for (int x = 365; x > 0; x--) {
	    	WeatherDate weatherDate = new WeatherDate();
	    	
	    	// TODO: fix this ugliness
		    Date now = new Date();
		    int yesterdayInt = now.getDate() - 1;
		    Date yesterday = new Date();
		    yesterday.setDate(yesterdayInt);
		    
		    int temperature = getRandomNumberInRange(-10, 110);
		    
		    weatherDate.setDate(yesterday);
		    weatherDate.setTemperature(temperature);
		    
		    weatherDates.add(weatherDate);
	    }
	    
		return weatherDates;
	}
	
	public List<WeatherDate> get365RealisticWeatherDates() {
		List<WeatherDate> weatherDates = new ArrayList<WeatherDate>();
		
		int currentTemp = 0;
	    for (int x = 365; x > 0; x--) {
	    	WeatherDate weatherDate = new WeatherDate();
	    	
	    	// TODO: fix this ugliness
		    Date now = new Date();
		    int yesterdayInt = now.getDate() - 1;
		    Date yesterday = new Date();
		    yesterday.setDate(yesterdayInt);
		    
		    int temp = -10;
		    TemperatureTrendType type;
	    	//make trend gradual...
		    if (x > 170) {
		    	type = TemperatureTrendType.WARMER;
		    	if ((x % 3) == 0) {
		    		type = TemperatureTrendType.UNCHANGING;
		    	} else if ((x % 4) == 0) {
		    		type = TemperatureTrendType.COOLER;
		    	}
			    temp = getTrendingRandomTempInRange(currentTemp, type);
		    } else {
		    	type = TemperatureTrendType.COOLER;
		    	if ((x % 3) == 0) {
		    		type = TemperatureTrendType.UNCHANGING;
		    	} else if ((x % 4) == 0) {
		    		type = TemperatureTrendType.WARMER;
		    	}
			    temp = getTrendingRandomTempInRange(currentTemp, type);
		    }
		    
		    weatherDate.setDate(yesterday);
		    weatherDate.setTemperature(temp);
		    
		    weatherDates.add(weatherDate);

		    currentTemp = temp;
	    }
	    
		return weatherDates;
	}
	
	
	private static int getTrendingRandomTempInRange(int previousTemp, TemperatureTrendType trend) {
		int temp;
		int min = previousTemp - 3;
		int max = previousTemp + 3;
		
		//set upper and lower bounds
		if (previousTemp > 110) {
			trend = TemperatureTrendType.UNCHANGING;
			min = 107;
			max = 112;
		} else if (previousTemp < -10){
			trend = TemperatureTrendType.UNCHANGING;
			min = -12;
			max = -8;
		}
		
		switch(trend) {
		case WARMER :
			temp = getRandomNumberInRange(min + 2, max + 2);
			break;
		case COOLER :
			temp = getRandomNumberInRange(min - 2, max - 2);
			break;
		default :
			temp = getRandomNumberInRange(min, max);
		}
		
		return temp;
	}
	
	// borrowed from Mkyong
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
