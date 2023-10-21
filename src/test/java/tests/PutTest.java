package tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class PutTest {

    private Response response;
    private RequestSpecification request;
    private String requestBody;

    @Given("I send a PUT request to {string}")
    public void i_send_a_PUT_request_to(String endpoint) {
        // Ganti URL dengan endpoint yang sesuai
        String baseUrl = "https://reqres.in";
        request = RestAssured.given().baseUri(baseUrl);

        // Mengatur header content type
        request.header("Content-Type", "application/json");
    }

    @Given("put request body is:")
    public void put_request_body_is(String docString) {
        // Mengambil body permintaan dari docString
        requestBody = docString;
    }

    @When("I send the PUT request")
    public void i_send_the_PUT_request() {
        // Mengatur body permintaan PUT
        request.body(requestBody);

        // Mengirim permintaan PUT
        response = request.put("/api/users/2"); // Ganti dengan ID yang sesuai
    }

    @Then("put response code is {int}")
    public void put_response_code_is(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("put response should contain {string}")
    public void put_response_should_contain(String expectedText) {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedText));
    }

    @Then("put response should contain job {string}")
    public void put_response_should_contain_job(String expectedJob) {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedJob));
    }
}
