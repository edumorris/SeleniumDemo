@web-ui
Feature: Drag & Drop
  # This feature has an issue on the UI side that needs fixing.
  This feature tests the drag & drop capabilities of a page

  Background:
    Given user opens the "the_internet_url" page
    And the user clicks the "Drag and Drop" link

  @wip @skip-scenario
  Scenario: Drag and Drop element A to element B
    When the user drags element A to element B
    Then the character inside element A should be 'B'
    And the character inside element B should be 'A'