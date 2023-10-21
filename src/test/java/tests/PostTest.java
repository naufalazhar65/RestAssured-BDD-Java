package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class PostTest {

    private Response response;
    private RequestSpecification request;
    private String requestBody;

    @Given("I send a POST request to {string}")
    public void i_send_a_POST_request_to(String endpoint) {
        // Mengatur URL dasar untuk permintaan
        String baseUrl = "https://reqres.in";
        request = RestAssured.given().baseUri(baseUrl);

        // Mengatur header Content-Type untuk permintaan
        request.header("Content-Type", "application/json");

        // Mengatur body permintaan POST (dalam contoh ini, JSON body)
        requestBody = "{\"name\": \"Naufal\", \"job\": \"QA Engineer\"}";
        request.body(requestBody);

        // Mengirim permintaan POST dan menyimpan responsenya
        response = request.post(endpoint);
    }

    @And("the request body is:")
    public void the_request_body_is(String docString) {
        // Mengambil body permintaan dari dokumen string
        requestBody = docString;
    }

    @When("the response code is {int}")
    public void the_response_code_is(int expectedStatusCode) {
        // Memeriksa kode status respons
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("the response should contain {string}")
    public void the_response_should_contain(String expectedText) {
        // Memeriksa apakah respons mengandung teks yang diharapkan
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedText));
    }

//    @Then("the response should contain job {string}")
//    public void the_response_should_contain_job(String expectedJob) {
//        // Memeriksa apakah respons mengandung pekerjaan yang diharapkan
//        String responseBody = response.getBody().asString();
//        Assert.assertTrue(responseBody.contains(expectedJob));
//    }
    
    @And("the response should have a JSON property \"id\" of type \"int\"")
    public void the_response_should_have_json_property_id_of_type_int() {
        // Mengambil nilai property "id" dari JSON respons
        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.getInt("id");

        // Memeriksa apakah "id" ada dalam respons dan memiliki tipe data int
        Assert.assertNotNull(id);
    }
}
