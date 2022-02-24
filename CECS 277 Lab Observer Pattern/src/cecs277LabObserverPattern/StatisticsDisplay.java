package cecs277LabObserverPattern;

import java.util.*;

/**
 * Gather running statistics on the weather measurements that have occurred
 * during the run of the program.
 * @author	David Brown
 * @date	09/20/2019
 */
public class StatisticsDisplay implements Observer, DisplayElement {
	/** The greatest temperature recorded in this run */
	private float maxTemp = 0.0f;
	/** The minimum temperature recorded in this run */
	private float minTemp = 200;
	/** The sum of all the temperature readings in this run */
	private float tempSum= 0.0f;
	/** The number of readings that we've taken thus far */
	private int numReadings;
	/** the WeatherData instance that got us started as a subscriber */
	private Subject weatherData;

	public StatisticsDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void update(WeatherData weather) {
		tempSum += weather.getTemperature();
		numReadings++;

		if (weather.getTemperature() > maxTemp) {
			maxTemp = weather.getTemperature();
		}
 
		if (weather.getTemperature() < minTemp) {
			minTemp = weather.getTemperature();
		}

		display();
	}

	@Override
	public void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
			+ "/" + maxTemp + "/" + minTemp);
	}
} // End of the StatisticsDisplay class