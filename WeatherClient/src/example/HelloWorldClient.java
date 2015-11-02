package example;
import com.jeffreyhwang.java.GlobalWeather;
/**
 * Created by Hwang on 10/5/15.
 */
public class HelloWorldClient {
  public static void main(String[] argv) {
      com.jeffreyhwang.java.GlobalWeatherSoap service = new GlobalWeather().getGlobalWeatherSoap();
      //invoke business method
      System.out.println(service.getCitiesByCountry("United States"));
      System.out.println(service.getWeather("Milwaukee", "United States"));
  }
}
