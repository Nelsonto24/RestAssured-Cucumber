package com.company.projectrestassuredcucumber.cucumber.stepdefs;

import com.company.projectrestassuredcucumber.cucumber.config.RedmineEndpoints;
import com.company.projectrestassuredcucumber.cucumber.entities.Entity;
import com.company.projectrestassuredcucumber.cucumber.entities.Project;
import io.cucumber.java.en.When;
import java.util.Map;
import java.util.Random;

public class RestCreateProjectStepDefs {
    /*private RequestSpecification request;
    private Response response;*/ //estas variables se declaran en la clase común ya que es reutilizada por los stepdefs
    private RestCommonStepDefs commonStepDefs;

    public RestCreateProjectStepDefs (RestCommonStepDefs commonStepDefs){ //inyectar variable common en el constructor
        this.commonStepDefs = commonStepDefs;
    }

    @When("System sends a request to create project service from redmine")
    public void systemSendsARequestToCreateProjectServiceFromRedmine(Map<String, String> projectData) { //transforma en un objeto tipo Map

        Integer randomNumber = (new Random()).nextInt(900000) + 100000;  //generar número aleatorio para que sea dinámico ya que el nombre del proyecto y el identificador deben ser únicos

        Project project = new Project();
        project.setName(projectData.get("name") + randomNumber);
        project.setIdentifier(projectData.get("identifier") + randomNumber);
        project.setDescription(projectData.get("description"));
        project.setIs_public(Boolean.parseBoolean(projectData.get("is_public")));


        Entity entity = new Entity(project);

        //request=given(); es una mala práctica repetir el código xq ya se indicó en el stepdef de la clase GetIssues

        commonStepDefs.response = commonStepDefs.request
                .body(entity)
                .when()
                .post(RedmineEndpoints.ALL_REDMINE_PROJECTS_JSON);
    }

}
