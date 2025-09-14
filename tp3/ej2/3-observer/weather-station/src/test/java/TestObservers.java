import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestObservers {

    @Test
    public void testThreeObservers() {
        WeatherData weatherData = new WeatherData();

        Observer currentDisplay =
                new CurrentConditionsDisplay(weatherData);
        Observer statisticsDisplay = new StatisticsDisplay(weatherData);
        Observer forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);
        /**
         * setMeasurements setea los atributos de temperature, humidity y pressure.
         * luego, llama a measurementsChanged() que llama a notifyObserver(),
         * que itera sobre los observadores y a c/u de ellos les aplica su update(t,h,p) 
         * sus updates luego de llevar a cabo sus respectivas logicas con respecto a sus atributos, 
         * llaman a display()
         */
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }

    @Test
    public void testRemoveObserver() {
        WeatherData weatherData = new WeatherData();

        Observer currentDisplay =
                new CurrentConditionsDisplay(weatherData);
        Observer statisticsDisplay = new StatisticsDisplay(weatherData);
        Observer forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);

        weatherData.removeObserver(forecastDisplay);
        weatherData.setMeasurements(62, 90, 28.1f);
    }
  
  @Test 
  public void testCelsiusDisplay(){
    WeatherData weatherData = new WeatherData();

    Observer celsiusDisplay = new CelsiusDisplay(weatherData);

    weatherData.registerObserver(celsiusDisplay);

    weatherData.setMeasurements(80,20,3.4f); //26.7 grados celsius 
    weatherData.setMeasurements(32,30,5.6f); //0 grados celsius 
    weatherData.setMeasurements(212,40,2); //100 grados celsius
  }

  @Test 
  public void testHeatIndexDisplay(){
    WeatherData weatherData = new WeatherData();

    Observer heatIndexDisplay = new HeatIndexDisplay(weatherData);

    weatherData.registerObserver(heatIndexDisplay);

    weatherData.setMeasurements(80,20,30);
  }

}
