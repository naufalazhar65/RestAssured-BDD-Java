package tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class DeleteTest {

    private Response response;
    private RequestSpecification request;

    @Given("I send a DELETE request to {string}")
    public void i_send_a_DELETE_request_to(String endpoint) {
        // Ganti URL dengan endpoint yang sesuai
        String baseUrl = "https://reqres.in";
        request = RestAssured.given().baseUri(baseUrl);
        response = request.delete(endpoint);
    }

    @When("delete response code is {int}")
    public void the_response_code_is(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("delete response should be empty")
    public void the_response_should_be_empty() {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.isEmpty());
    }
}
