@reagentlibrary
@CC-1128_Edit_one_reagent_item
Feature: CC-1128:Edit one reagent item

    This test case is to make sure the user could edit Reagent item.

    Background: User is on Reagent menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Library"
    Then user is navigated to "Reagent Library" page
    And "Reagent 1" items is "already" exist

    Scenario: Select and Edit an reagent item
    When user select an item "Reagent 1" by check the checkbox
    Then item "Reagent 1" is checked
    And icon "edit" is enabled in page
    When user clicks on "edit" icon
    Then user is navigated to "Edit Reagent" page
    When user "change" "Reagent 1.0" in "name" textbox
    And user "change" "Reagent 1.0 with Antibiotic" in "notes" textbox
    And user clicks on "Save" button
    Then modal "Save Confirm" confirmation is displayed
    When user clicks on "OK" button
    Then notification "Success" and "Reagent has been updated" is displayed
    And item "Reagent 1" change to be "Reagent 1.0"
    And user is navigated to "Reagent Library" page