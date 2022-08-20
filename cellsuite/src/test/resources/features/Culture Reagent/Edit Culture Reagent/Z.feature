@reagentculture
@z
Feature: delete Reagent 7.0 Culture, 8.0, 9.0

    Feature Description

    Background: User is on Culture Reagent menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Culture Reagent"
    Then user is navigated to "Culture Reagent" page
    And "Reagent 7.0 Culture" items is "already" exist
    And "Reagent 8.0 Culture" items is "already" exist
    And "Reagent 9.0 Culture" items is "already" exist

    Scenario: Select and Delete an Culture reagent item
    When user select an item "Reagent 7.0 Culture" by check the checkbox
    Then item "Reagent 7.0 Culture" is checked
    And icon "delete" is enabled in page
    When user select an item "Reagent 8.0 Culture" by check the checkbox
    Then item "Reagent 8.0 Culture" is checked
    When user select an item "Reagent 9.0 Culture" by check the checkbox
    Then item "Reagent 9.0 Culture" is checked
    When user clicks on "delete" icon
    Then modal "Delete Culture Reagent" confirmation is displayed
    When user clicks on "OK" button in modal
    Then notification "Success" and "Culture Reagents has been deleted" is displayed
    And "Reagent 7.0 Culture" items is "not" exist
    And "Reagent 8.0 Culture" items is "not" exist
    And "Reagent 9.0 Culture" items is "not" exist
    When user refresh the browser page
    Then user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Culture Reagent"
    Then user is navigated to "Culture Reagent" page
    And "Reagent 7.0 Culture" items is "not" exist
    And "Reagent 8.0 Culture" items is "not" exist
    And "Reagent 9.0 Culture" items is "not" exist

