import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    private Coordinates coord;

    private String base;

    // Either use Java Class which has all sub Json Node field information
    //line List<WeatherInformation>
    //or we can use JsonNode to capture all the sub json data all at once...
    private JsonNode weather;

    WeatherResponse(){}

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

    public JsonNode getWeather() {
        return weather;
    }

    public void setWeather(JsonNode weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}
