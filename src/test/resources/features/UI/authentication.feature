@web-ui
Feature: Digest Authentication
  This feature tests digest authentication

  Background:
    Given user opens the "the_internet_url" page

  Scenario Outline: Test correct credentials for "<authentication type>"
    And the user clicks the "<authentication type>" link
    When the user enters the correct "<username>" and "<password>" for "<authentication type>"
    Then the user should see the authentication page with the header "<authentication text>"
    And the text "Congratulations! You must have the proper credentials."
    Examples:
      | username | password | authentication type | authentication text |
      | auth_uname    | auth_pwd    | Basic Auth |  Basic Auth |
      | auth_uname    | auth_pwd    | Digest Authentication |  Digest Auth |
    # The digest authentication mechanism might need to be checked. Works the same as basic auth.