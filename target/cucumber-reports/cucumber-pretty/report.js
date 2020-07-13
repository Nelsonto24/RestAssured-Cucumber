$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/com/company/projectrestassuredcucumber/cucumber/features/rest-create-project.feature");
formatter.feature({
  "name": "REST - Redmine REST testing - Create project",
  "description": "  As a user...\n  I want to ...",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Create an project - JSON",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ApiRest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "System is ready to sent request",
  "keyword": "Given "
});
formatter.match({
  "location": "com.company.projectrestassuredcucumber.cucumber.stepdefs.RestCommonStepDefs.systemIsReadyToSendRequest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "System sends a request to create project service from redmine",
  "rows": [
    {},
    {},
    {},
    {}
  ],
  "keyword": "When "
});
formatter.match({
  "location": "com.company.projectrestassuredcucumber.cucumber.stepdefs.RestCreateProjectStepDefs.systemSendsARequestToCreateProjectServiceFromRedmine(java.util.Map\u003cjava.lang.String, java.lang.String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The response status should be 201",
  "keyword": "Then "
});
formatter.match({
  "location": "com.company.projectrestassuredcucumber.cucumber.stepdefs.RestCommonStepDefs.theResponseStatusShouldBe(int)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/com/company/projectrestassuredcucumber/cucumber/features/rest-get-issues.feature");
formatter.feature({
  "name": "REST - Redmine REST testing - Get issues",
  "description": "  As a user...\n  I want to ...",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Get issues by list - JSON",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ApiRest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "System is ready to sent request",
  "keyword": "Given "
});
formatter.match({
  "location": "com.company.projectrestassuredcucumber.cucumber.stepdefs.RestCommonStepDefs.systemIsReadyToSendRequest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "System sends a request to list issues service from redmine json",
  "keyword": "When "
});
formatter.match({
  "location": "com.company.projectrestassuredcucumber.cucumber.stepdefs.RestGetIssuesStepDefs.systemSendsARequestToListIssuesServiceFromRedmineJson()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The response status should be 200",
  "keyword": "Then "
});
formatter.match({
  "location": "com.company.projectrestassuredcucumber.cucumber.stepdefs.RestCommonStepDefs.theResponseStatusShouldBe(int)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Get issues by id - JSON",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ApiRest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "System is ready to sent request",
  "keyword": "Given "
});
formatter.match({
  "location": "com.company.projectrestassuredcucumber.cucumber.stepdefs.RestCommonStepDefs.systemIsReadyToSendRequest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "System sends a request to get issues by id service from redmine",
  "rows": [
    {}
  ],
  "keyword": "When "
});
formatter.match({
  "location": "com.company.projectrestassuredcucumber.cucumber.stepdefs.RestGetIssuesStepDefs.systemSendsARequestToGetIssuesByIdServiceFromRedmine(java.util.Map\u003cjava.lang.String, java.lang.String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The response status should be 200",
  "keyword": "Then "
});
formatter.match({
  "location": "com.company.projectrestassuredcucumber.cucumber.stepdefs.RestCommonStepDefs.theResponseStatusShouldBe(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "System should responds with response data",
  "rows": [
    {},
    {},
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "com.company.projectrestassuredcucumber.cucumber.stepdefs.RestGetIssuesStepDefs.systemShouldRespondsWithResponseData(java.util.Map\u003cjava.lang.String, java.lang.String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});