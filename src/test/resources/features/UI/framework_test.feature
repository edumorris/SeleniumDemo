@web-ui
Feature: # Enter feature name here
  # Enter feature description here

  @wip
  Scenario: The Internet Homepage Title Check
    Given user opens the "the_internet_url" page
    Then the title "Welcome to the-internet" should exists

  @wip
  Scenario: Failing test homepage check
    Given user opens the "the_internet_url" page
    Then the title "Welcome to the internet" should exists