@reagentlibrary
@CC-1105_Delete_one_reagent_item
Feature: CC-1105:Delete one reagent item

    This test case is to make sure the user could delete Reagent item.

    Background: User is on Reagent menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Library"
    Then user is navigated to "Reagent Library" page
    And "Reagent 3" items is "already" exist

    Scenario: Select and Delete an reagent item
    When user select an item "Reagent 3" by check the checkbox
    Then item "Reagent 3" is checked
    And icon "delete" is enabled in page
    When user clicks on "delete" icon
    Then modal "Delete reagents" confirmation is displayed
    When user clicks on "OK" button in modal
    Then notification "Success" and "Reagents has been deleted" is displayed
    And "Reagent 3" items is "not" exist
    When user refresh the browser page
    Then user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Library"
    Then user is navigated to "Reagent Library" page
    And "Reagent 3" items is "not" exist
    