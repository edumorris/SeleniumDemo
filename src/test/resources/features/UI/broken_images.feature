@web-ui
Feature: Check for broken images
  This feature tests for broken images on a web page

  Background:
    Given user opens the "the_internet_url" page

  @wip
  Scenario: Check whether an image is broken
    When the user accesses the "Broken Images" link
    Then the user should be able to see all images