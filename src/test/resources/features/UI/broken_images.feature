@web-ui
Feature: Check for broken images
  This feature tests for broken images on a web page

  Background:
    Given user opens the "the_internet_url" page

  Scenario: Check whether an image is broken
    # This test will fail if there is a broken image in the page
    When the user accesses the "Broken Images" link
    Then the user should be able to see all images