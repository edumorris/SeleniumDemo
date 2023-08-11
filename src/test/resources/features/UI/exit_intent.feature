@web-ui
  Feature: Exit intent
    This feature tests that the user receives a modal popup once the mouse goes out of view port. Commonly used to encourage user to take acion like submit email or buy something

  Background:
    Background:
      Given user opens the "the_internet_url" page
      And the user clicks the "Exit Intent" link

      Scenario: Check that a modal is displayed once the mouse moves out of viewport
        When the user moves the mouse out of viewport
        Then the modal popup is displayed

      Scenario: Check the modal is not displayed again after being closed
        When the user moves the mouse out of viewport
        And the modal popup is displayed
        And the modal popup is closed
        When the user moves the mouse out of viewport
        Then the modal popup should not be displayed