package cecs277LabObserverPattern;

public class ObserverRunner {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay (weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay (weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		WindConditionsDisplay windConditionsDisplay = new WindConditionsDisplay(weatherData);
		weatherData.setMeasurements(80,  65,  30.4f, 0, 45);
		weatherData.setMeasurements(82,  70,  29.2f, 0, 56);
		weatherData.setMeasurements(78,  90,  29.2f, 300, 56);
		weatherData.setMeasurements(40,  40,  25.2f, 15, 90);
		System.out.println("Completed satisfactorily.");
	}

}