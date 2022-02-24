package cecs277LabObserverPattern;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	/** The temperature that we pick up from the weatherData */
	private float temperature;
	/** The humidity */
	private float humidity;
	/** The  Subject instance that we are going to subscribe to. */
	private Subject weatherData;
	
	/**
	 * Constructor for this concrete implementation of the Observer interface.
	 * @param	weatherData	The subject that we're observing.  We could have
	 * 						subscribed in the main program just as easily.
	 */
	public CurrentConditionsDisplay(Subject weatherData) {
		//Aggregate the weatherData Subject instance for later reference
		this.weatherData = weatherData;
		//Tell that Subject that we are interested in observing them.
		//I don't pick up the return value from registerObserver because I 
		//know that I cannot be in that list yet since I just got created.
		this.weatherData.registerObserver(this);
	}
	@Override
	public void display() {
		System.out.println("Current conditions: " + this.temperature + "F degrees and " + 
				this.humidity + "% humidity");
	}

	@Override
	public void update(WeatherData weather) {
		this.temperature = weather.getTemperature();
		this.humidity = weather.getHumidity();
		this.display();
	}

}
