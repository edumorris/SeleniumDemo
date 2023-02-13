@web-ui
Feature: Test adding or removing element
  This test tests an element dynamically appearing and disappearing.

  Background:
    Given user opens the "the_internet_url" page
    And the user clicks the "Add/Remove Elements" link
    And the user clicks the "Add Element" button

  Scenario: Testing appearing elements
    Then a button with the class "added-manually" and the text "Delete" should appear

  Scenario: Testing disappearing elements
    When user clicks the "Delete" button
    Then the "Delete" button should no longer be visible
