package cucumber.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReqResStepDefinitions {

    @Given("The input details to POST API")
    public void getInputsOfREQ_RES_API() {
        System.out.println("This is Input method of REQRES POST API");
    }

    @Given("The input details to PUT API")
    public void getInputsOfREQ_RES_PUT_API() {
        System.out.println("This is Input method of REQRES PUT API");
    }


    @Given("The API is executed")
    public void triggerThePOSTAPI() {
        System.out.println("This is Trigger method of REQRES");
    }


    @Given("Validate the POST response")
    public void validateTheResponse() {
        System.out.println("This is Validation method of REQRES POST API");
    }

    @Given("Validate the PUT response")
    public void validateThe_PUT_Response() {
        System.out.println("This is Validation method of REQRES PUT API");
    }
}
