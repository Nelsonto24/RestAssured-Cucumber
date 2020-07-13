package com.company.projectrestassuredcucumber.cucumber.stepdefs;

import com.company.projectrestassuredcucumber.cucumber.config.RedmineEndpoints;
import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestGetIssuesStepDefs {
    /*private RequestSpecification request;
    private Response response;*/ //estas variables se declaran en la clase común ya que es reutilizada por los stepdefs
    private RestCommonStepDefs commonStepDefs;  //sirve para compartir estados de las variables

    public RestGetIssuesStepDefs(RestCommonStepDefs commonStepDefs){ //inyectar variable common en el constructor. Se agrega la dependencia PicoContainer en el pom.xml
        this.commonStepDefs = commonStepDefs;
    }

    /*@Given("System is ready to sent request") //este método se implementa en la clase common ya que es reutilizado por los stepdefs
    public void systemIsReadyToSendRequest(){
        request = given();
    }*/

    @When("System sends a request to list issues service from redmine json")
    public void systemSendsARequestToListIssuesServiceFromRedmineJson() {
        commonStepDefs.response = commonStepDefs.request
                .when()
                //.log()  se indica en la clase Hooks (anteriormente RedmineConfig)
                //.all()  se indica en la clase Hooks (anteriormente RedmineConfig)
                //.get("http://192.168.0.5:8081/issues.json");
                .get(RedmineEndpoints.ALL_REDMINE_ISSUES_JSON);
    }

    /*@Then("The response status should be {int}")  //este método se implementa en la clase common ya que es reutilizado por los stepdefs
    public void theResponseStatusShouldBe(int code) {
        response.then()
                .log()  //   se indica en la clase Hooks (anteriormente RedmineConfig)
                .all()  //   se indica en la clase Hooks (anteriormente RedmineConfig)
                .statusCode(code);
    }*/

    @When("System sends a request to get issues by id service from redmine")
    public void systemSendsARequestToGetIssuesByIdServiceFromRedmine(Map<String, String> issue) {  //transforma en un objeto tipo Map
        commonStepDefs.response = commonStepDefs.request
                .pathParam("id",issue.get("id")) // se accede a través de la llave id
                .when()
                .get(RedmineEndpoints.SINGLE_REDMINE_ISSUE_JSON);
    }

    @And("System should responds with response data")
    public void systemShouldRespondsWithResponseData(Map<String, String> expectedData) { //transforma en un objeto tipo Map
        JsonPath actualData = new JsonPath(commonStepDefs.response.getBody().asString()); //data obtenida en el repsonse

        Assert.assertEquals(Integer.parseInt(expectedData.get("id")), actualData.getInt("issue.id")); //compara el id recibido como string(lo convierte a entero) vs el id del issue
        Assert.assertEquals(expectedData.get("subject"), actualData.getString("issue.subject"));  //los assert solo se hacen en los stepdefs
        Assert.assertEquals(expectedData.get("description"), actualData.getString("issue.description"));
        Assert.assertEquals(expectedData.get("start_date"), actualData.getString("issue.start_date"));
    }
}
