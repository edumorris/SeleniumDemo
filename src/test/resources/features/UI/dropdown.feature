@web-ui
Feature: Dropdown
  This feature tests the interaction of a drop down

  Background:
    Given user opens the "the_internet_url" page
    And the user clicks the "Dropdown" link

  Scenario Outline: Select an "<option>"
    When the user selects "<option>"
    Then the value of the drop down should be "<option>"
    Examples:
      | option    |
      | Option 1  |
      | Option 2  |
