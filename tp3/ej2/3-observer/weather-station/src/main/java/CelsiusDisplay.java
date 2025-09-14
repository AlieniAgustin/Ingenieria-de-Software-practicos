public class CelsiusDisplay implements Observer, DisplayElement{
  private float celsiusTemp;
  private WeatherData weatherData;

  public CelsiusDisplay(WeatherData weatherData){ 
    this.weatherData = weatherData;
  }

  public void update(){
    float temp = weatherData.getTemperature();
    celsiusTemp = (temp - 32) * (5.0f/9);
    display();
  }

  public void display(){
    System.out.println(celsiusTemp + " C degrees.");
  }
}
