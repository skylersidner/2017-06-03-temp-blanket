package com.mindcanary.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindcanary.domain.weatherDate.WeatherDate;
import com.mindcanary.domain.weatherDate.WeatherDateDomainService;


@RestController
@RequestMapping("/weatherDate")
public class WeatherDateController {

	@Inject
	private WeatherDateDomainService weatherDateDomainService;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public List<WeatherDate> getLastYear() {
		List<WeatherDate> response = weatherDateDomainService.getLastYear();
		
		return response;
	}
}
