import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Kaarthik
public class Driver {


    public static void main(String[] args) {

        RestAssured.baseURI = "https://api.openweathermap.org";

        Map<String, Object> cityAndAppIdInformationParams = new HashMap<>();
        cityAndAppIdInformationParams.put("q", "mumbai");
        cityAndAppIdInformationParams.put("appid", "5661a8ed7941f24452984807b47e5b89");

        RequestSpecification weatherRequest = RestAssured.given();

        weatherRequest.queryParams(cityAndAppIdInformationParams);


        Response response = weatherRequest.get("/data/2.5/weather");

        response.prettyPrint();

        WeatherResponse weatherResponse = response.as(WeatherResponse.class);

        System.out.println(weatherResponse.getCoord());

        System.out.println(weatherResponse.getCoord().getLat());

        System.out.println(weatherResponse.getWeather().get(0).get("description"));

        //weatherResponse.prettyPrint();

//        JsonPath weatherResponseJsonPath = weatherResponse.jsonPath();
//        Map<String, Object> coord = weatherResponseJsonPath.getMap("coord");
//
//        String cityName = weatherResponseJsonPath.getString("name");
//
//        System.out.println(cityName);
//
//        System.out.println("The longitude of the city is " + coord.get("lon"));
//
//        List<Map<String, Object>> weatherInformation = weatherResponseJsonPath.getList("weather");
//
//        System.out.println(weatherInformation.get(0).get("description"));


    }


}
