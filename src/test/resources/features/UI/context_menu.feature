@web-ui
Feature: Context Menu
  This feature test custom context menu is triggered

  Background:
    Given user opens the "the_internet_url" page
    And the user clicks the "Context Menu" link

  Scenario: JavaScript alert appears when users right click's context area
    When the user right clicks the context menu box
    Then a JavaScript alert with the message "You selected a context menu" appears