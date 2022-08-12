@reagentlibrary
@CC-1130_Edit_multiple_reagent_item
Feature: CC-1130:Edit multiple reagent item

    This test case is to make sure the user could edit multiple Reagent items

    Background: User is on Reagent menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Library"
    Then user is navigated to "Reagent Library" page
    And reagent items is already exist

    Scenario: Select and Edit some reagent item
    When user select an reagent item "Reagent 2" by check the checkbox
    Then reagent checkbox "Reagent 2" item is checked
    And icon "edit" is enabled in page
    When user select an reagent item "Reagent 3" by check the checkbox
    Then reagent checkbox "Reagent 3" item is checked
    When user clicks on "edit" icon in page
    Then user is navigated to "Edit Reagent" page
    When user change "name" with "Reagent 2.0"
    And user change "note" with "Reagent 2 with Antibiotic"
    And user clicks on "save" button in page
    Then modal "Save Confirm" confirmation is displayed
    When user clicks on "OK" button in modal
    Then notification "Success" and "Reagent has been updated" is displayed
    When user clicks on "next" icon in page
    When user change "name" with "Reagent 3.0"
    And user change "note" with "Reagent 3 with Antibiotic"
    And user clicks on "save" button in page
    Then modal "Save Confirm" confirmation is displayed
    When user clicks on "OK" button in modal
    Then notification "Success" and "Reagent has been updated" is displayed
    When user clicks on "close" icon in page
    And user is navigated to "Reagent Library" page