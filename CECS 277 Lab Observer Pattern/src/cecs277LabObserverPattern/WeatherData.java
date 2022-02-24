package cecs277LabObserverPattern;

import java.util.ArrayList;

public class WeatherData implements Subject {
	/** Our list of current observers. */
	private ArrayList <Observer> observers;
	/** The temperature reading */
	private float temperature;
	/** The humidity reading */
	private float humidity;
	/** The air pressure reading */
	private float pressure;
	/** The direction of the wind */
	private float direction;
	/** the wind speed in miles/hours */
	private float speed;
	
	/**
	 * default constructor, create a new ArrayList for observers
	 */
	public WeatherData () {
		this.observers = new ArrayList <> ();
	}
	
	// getter methods for all the weather measurements
	/**
	 * Returns the temperature
	 * @return the temperature
	 */
	public float getTemperature() {
		return this.temperature;
	}
	
	/**
	 * Returns the humidity
	 * @return the humidity
	 */
	public float getHumidity() {
		return this.humidity;
	}
	
	/**
	 * Returns the pressure
	 * @return the air pressure reading
	 */
	public float getPressure() {
		return this.pressure;
	}
	
	/**
	 * Returns the direction of the wind
	 * @return the direction
	 */
	public float getDirection() {
		return this.direction;
	}
	
	/**
	 * Returns the speed of the wind
	 * @return the speed
	 */
	public float getSpeed() {
		return this.speed;
	}
	
	@Override
	public boolean registerObserver(Observer observer) {
		if (observers.contains(observer)) {
			return false;
		} else {
			observers.add(observer);
			return true;
		}
	}

	@Override
	public boolean removeObserver (Observer observer) {
		if (observers.contains(observer)) {
			observers.remove(observer);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void notifyObservers() {
		for (Observer next: this.observers) {
			next.update(this);
		}
	}

	/**
	 * This is a little hokey, but here goes.  Rather than call notifyObservers directly,
	 * we're going to encapsulate that a little bit, and use a method as an interface of
	 * sorts in front of notifyObservers.
	 */
	public void measurementsChanged () {
		notifyObservers();
	}
	
	/**
	 * Update one or more of the weather measurements.
	 * @param	temperature		New value for the temperature.
	 * @param	humidity		New value for the humidity.
	 * @param	pressure		New value for the barometric pressure.
	 * @param	direction 		New value for the direction of wind
	 * @param	speed			New value for the wind speed
	 */
	public void setMeasurements (float temperature, float humidity, float pressure, float direction, float speed) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		this.direction = direction;
		this.speed = speed;
		measurementsChanged();							//signal that one or more measurements have changed
	} // End of the setMeasurements member method
} // End of the WeatherData class