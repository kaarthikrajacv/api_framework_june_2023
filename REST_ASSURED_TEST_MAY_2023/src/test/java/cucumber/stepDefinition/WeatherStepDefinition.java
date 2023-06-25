package cucumber.stepDefinition;

import cucumber.excelData.ExcelDataTable;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class WeatherStepDefinition {

    RequestSpecification weatherRequest;

    Response response;

    Scenario scenario;

    String cityName;

    List<String> cities;

    @BeforeAll
    public static void setReportingProperties() throws Exception{
        //FileOutputStream out = new FileOutputStream("src/main/resources/extent.properties");
        FileInputStream in = new FileInputStream("src/test/resources/extent.properties");
        Properties props = new Properties();
        props.load(in);
        Date date = new Date();
        props.setProperty("extent.reporter.spark.out", "test-output/SparkReport/" + date.getTime() + ".html");
        in.close();
        props.setProperty("country", "america");

        FileOutputStream out = new FileOutputStream("src/test/resources/extent.properties");

        props.store(out, null);
        out.close();
    }

    @Before
    public void beforeMethodOfWeatherAPI(Scenario scenario) throws Exception {
        this.scenario = scenario;
        System.out.println("Before First Step of Each Scenario");

    }


    @Given("The inputs to weather API for testing city")
    public void the_inputs_to_weather_api_for_testing_mumbai_city() throws Exception {

        ExcelDataTable excelDataTable = new ExcelDataTable("src/test/resources/excel_data/weather_data.xls");

        excelDataTable.createConnection();

        this.cities = excelDataTable.getIterativeDataFromExcel(scenario.getName());

        System.out.println("This is giving inputs step");

        RestAssured.baseURI = "https://api.openweathermap.org";
    }

    @When("The Weather API is executed")
    public void the_weather_api_is_executed() {

        System.out.println("This is the Execution of API step");

        for(String city : cities){

            Map<String, Object> cityAndAppIdInformationParams = new HashMap<>();
            cityAndAppIdInformationParams.put("q", city);
            cityAndAppIdInformationParams.put("appid", "5661a8ed7941f24452984807b47e5b89");

            weatherRequest = RestAssured.given();

            weatherRequest.queryParams(cityAndAppIdInformationParams);
            response = weatherRequest.get("/data/2.5/weather");

            response.prettyPrint();

        }
    }

    @Then("Validate the response of the weather API")
    public void validate_the_response_of_the_weather_api() {

        System.out.println("This is the Validating response step" + cities);
    }

}
