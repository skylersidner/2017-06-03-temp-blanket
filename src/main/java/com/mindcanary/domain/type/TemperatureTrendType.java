package com.mindcanary.domain.type;

import com.mindcanary.exceptions.EnumerationException;

public enum TemperatureTrendType {
	
	WARMER("Warmer"),
	COOLER("Cooler"),
	UNCHANGING("Unchanging");

	private String description;
	
	private TemperatureTrendType(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static TemperatureTrendType fromDescription(String description) {
		if (null != description) {
			for (TemperatureTrendType temperatureTrend : TemperatureTrendType.values()) {
				if (temperatureTrend.getDescription().equalsIgnoreCase(description)) {
					return temperatureTrend;
				}
			}
		}
		throw new EnumerationException();
	}
}
