@web-ui
Feature: Framework Test & Background
  This feature tests the basic dependencies and working of the framework

  Background:
    Given user opens the "the_internet_url" page

  @wip
  Scenario: The Internet Homepage Title Check
    Then the title "Welcome to the-internet" should exists

  @wip
  Scenario: Failing test homepage check
    Then the title "Welcome to the internet" should exists