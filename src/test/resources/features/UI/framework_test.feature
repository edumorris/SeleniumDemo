@web-ui
Feature: Framework Test & Background
  This feature tests the basic dependencies and working of the framework

  Background:
    Given user opens the "the_internet_url" page

  Scenario: The Internet Homepage Title Check
    Then the title "Welcome to the-internet" should exists

  Scenario: Failing test homepage check
    # This test should fail
    Then the title "Welcome to the internet" should exists