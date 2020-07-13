Feature: REST - Redmine REST testing - Get issues
  As a user...
  I want to ...

  @ApiRest
  Scenario: Get issues by list - JSON
    Given System is ready to sent request
    When System sends a request to list issues service from redmine json
    Then The response status should be 200

  @ApiRest
  Scenario: Get issues by id - JSON
    Given System is ready to sent request
    When System sends a request to get issues by id service from redmine
      | id | 2 |
    Then The response status should be 200
    And System should responds with response data
      | id          | 2                                                     |
      | subject     | Mi segundo issue creado desde RestAssured con JSON    |
      | description | As an admin user, I cannot create an user when...     |
      | start_date  | 2020-04-25                                            |