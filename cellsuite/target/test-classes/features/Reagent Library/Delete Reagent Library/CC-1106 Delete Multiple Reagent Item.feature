@reagentlibrary
@CC-1106_Delete_multiple_reagent_item
Feature: CC-1106:Delete multiple reagent item

    This test case is to make sure the user could delete multiple Reagent item.

   Background: User is on Reagent menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Library"
    Then user is navigated to "Reagent Library" page
    And "Reagent 4" items is "already" exist
    And "Reagent 5" items is "already" exist

    Scenario: Select and Delete an reagent item
    When user select an item "Reagent 4" by check the checkbox 
    Then item "Reagent 4" is checked 
    And icon "delete" is enabled in page
    When user select an item "Reagent 5" by check the checkbox 
    Then item "Reagent 5" is checked 
    When user clicks on "delete" icon
    Then modal "Delete reagents" confirmation is displayed
    When user clicks on "OK" button
    Then notification "Success" and "Reagents has been deleted" is displayed
    And "Reagent 4" items is "not" exist
    And "Reagent 5" items is "not" exist
    When user refresh the browser page
    Then user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Library"
    Then user is navigated to "Reagent Library" page
    And "Reagent 4" items is "not" exist
    And "Reagent 5" items is "not" exist
