@reagentculture
@CC-1110_Delete_One_Culture_Reagent
Feature: CC-1110:Delete One Culture Reagent

    This test case is to make sure the user could delete Culture Reagent item

    Background: User is on Culture Reagent menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Culture Reagent"
    Then user is navigated to "Culture Reagent" page
    And "Reagent 10 Culture" items is "already" exist

    Scenario: Select and Delete an Culture reagent item
    When user select an item "Reagent 10 Culture" by check the checkbox
    Then item "Reagent 10 Culture" is checked
    And icon "delete" is enabled in page
    When user clicks on "delete" icon
    Then modal "Delete Culture Reagent" confirmation is displayed
    When user clicks on "OK" button in modal
    Then notification "Success" and "Culture Reagents has been deleted" is displayed
    And "Reagent 10 Culture" items is "not" exist
    When user refresh the browser page
    Then user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Culture Reagent"
    Then user is navigated to "Culture Reagent" page
    And "Reagent 10 Culture" items is "not" exist
    