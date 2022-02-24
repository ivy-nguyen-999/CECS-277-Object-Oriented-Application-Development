package cecs277LabObserverPattern;

public interface Observer {
	/**
	 * The method that the subject calls on each observer/subscriber to 
	 * notify them of the changes in the weather readings.
	 * @param	temp		New temperature reading
	 * @param	humidity	New humidity reading
	 * @param	pressure	New air pressure reading
	 * @param	direction 	New value for the direction of wind
	 * @param	speed		New value for the wind speed
	 */
	public void update (WeatherData weather);
}