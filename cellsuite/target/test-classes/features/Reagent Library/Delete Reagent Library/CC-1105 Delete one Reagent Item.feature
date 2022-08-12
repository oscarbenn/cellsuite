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
    And reagent items is already exist

    Scenario: Select and Delete an reagent item
    When user select an reagent item "Reagent 1" by check the checkbox
    Then reagent checkbox "Reagent 1" item is checked
    And icon "delete" is enabled in page
    When user clicks on "delete" icon in page
    Then modal "Delete reagents" confirmation is displayed
    When user clicks on "OK" button in modal
    Then notification "Success" and "Reagents has been deleted" is displayed
    And there is no item reagent "Reagent 1"
    When user refresh the browser page
    Then user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Library"
    Then user is navigated to "Reagent Library" page
    And there is no item reagent "Reagent 1"
    