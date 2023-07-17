@web-ui @wip
  Feature: Entry Advertisement
    This feature tests an advertisement displayed when a page loads

  Background:
    Given user opens the "the_internet_url" page
    And the user clicks the "Entry Ad" link

  Scenario: Check that the advertisement is displayed
    Then the user should "see" the advertisement

  Scenario: Check that the ad does not show on reload
    When the page reloads
    Then the user should "not see" the advertisement
