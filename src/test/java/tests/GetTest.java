package tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class GetTest {

    private Response response;
    private RequestSpecification request;

    @Given("I send a GET request to {string}")
    public void i_send_a_GET_request_to(String endpoint) {
        String baseUrl = "https://reqres.in";
        request = RestAssured.given().baseUri(baseUrl);
        response = request.get(endpoint);
    }

    @When("response code is {int}")
    public void the_response_code_is(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("response should contain {string}")
    public void the_response_should_contain(String expectedText) {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedText));
    }
}
