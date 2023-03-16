@web-ui
Feature: Disappearing Elements
  This feature tests disappearing elements

  Background:
    Given user opens the "the_internet_url" page
    And the user clicks the "Disappearing Elements" link

  Scenario: Open the gallery page
    # The gallery link keeps disappearing
    When the user tries to access "gallery" link
    Then the url should be "https://the-internet.herokuapp.com/gallery/"