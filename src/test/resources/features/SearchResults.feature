Feature: As user, I want to be able to search for goods

  Scenario: 1. Search for wooden spoon and verify that every search result contains it
    Given user clicks on get started button
    And user logs in
    When user searches for "wooden spoon"
    Then user verifies that every search result contains "wooden spoon"
