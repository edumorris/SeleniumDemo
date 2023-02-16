@web-ui
Feature: Basic Authentication
  This feature tests basic authentication from a JavaScript Alert

  Background:
    Given user opens the "the_internet_url" page
    And the user clicks the "Basic Auth" link

  Scenario Outline: Test correct credentials
    When the user enters the correct "<username>" and "<password>"
    Then the user should see the authentication page with the header "Basic Auth"
    And the text "Congratulations! You must have the proper credentials."
    Examples:
      | username | password |
      | basic_auth_uname    | basic_auth_pwd    |