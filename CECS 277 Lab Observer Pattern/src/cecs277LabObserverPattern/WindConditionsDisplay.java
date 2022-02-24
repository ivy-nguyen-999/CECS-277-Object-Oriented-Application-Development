package cecs277LabObserverPattern;

public class WindConditionsDisplay implements Observer, DisplayElement {
	
	/** The direction of the wind */
	private float currentDirection;
	/** the current wind speed in miles/hours */
	private float currentSpeed;
	/** the previous wind speed in miles/hours */
	private float previousSpeed;
	/** The Subject that we're observing */
	private Subject weatherData;
	
	public WindConditionsDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Wind Forecast: " + windCondition());
		System.out.println("Wind blowing out of the: " + windDirection());
	}

	@Override
	public void update(WeatherData weather) {
		this.currentDirection = weather.getDirection();
		this.previousSpeed = currentSpeed;
		this.currentSpeed = weather.getSpeed();
		display();
		
	}
	
	private String windDirection() {
		// make sure direction is in range 0 -> 360
		if (this.currentDirection > 360) {this.currentDirection -= 360;}
		else if (this.currentDirection < 0) {this.currentDirection += 360;}
		
		String returnString = "";
		
		if (this.currentDirection >= 45 && this.currentDirection < 135) {returnString = "East";}
		else if (this.currentDirection >= 135 && this.currentDirection < 225) {returnString = "South";}
		else if (this.currentDirection >= 225 && this.currentDirection < 315) {returnString = "West";}
		else {returnString = "North";}
		
		return returnString;
	}
	
	private String windCondition() {
		String returnString = "";
		// if the current wind speed is greater than 100
		if (this.currentSpeed > 100) {
			returnString = "Conditions strong, please get into a shelter";
		}
		// if the current wind speed is less than 50
		else if (this.currentSpeed < 50) {
			returnString = "Good kite flying weather.";
		}
		// if the current speed equals to the previous speed
		// or the previous speed is less than 50, while the current speed is between 50 and 100
		else if (this.currentSpeed == this.previousSpeed || this.previousSpeed < 50) {
			returnString = "Conditions moderate.";
		}
		// if the current speed is moderate and greater than the previous speed
		else if (this.currentSpeed >= 50 && this.currentSpeed <= 100 && this.currentSpeed > this.previousSpeed) {
			returnString = "Conditions moderate and worsening.";
		}
		// if the current speed is moderate and less than the previous speed
		else if (this.currentSpeed >= 50 && this.currentSpeed <= 100 && this.currentSpeed < this.previousSpeed) {
			returnString = "Conditions moderate and getting better.";
		}
		return returnString;
	}
}
