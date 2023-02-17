@web-ui
Feature: Checkboxes
  This feature test whether a checkbox is checked or not

  Background:
    Given user opens the "the_internet_url" page
    And the user clicks the "Checkboxes" link

  Scenario: Check the initial status of the checkboxes
    Then the "first" checkbox should not be checked
    But the "second" checkbox should be checked

  Scenario:  Check the first checkbox
    When the user clicks the "first" checkbox
    Then the "first" checkbox should be checked

  Scenario: Uncheck the second checkbox
    When the user clicks the "second" checkbox
    Then the "second" checkbox should not be checked