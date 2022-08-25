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
    And "Reagent 6" items is "already" exist
    And "Reagent 7" items is "already" exist

    Scenario: Select and Edit some reagent item
    When user select an item "Reagent 6" by check the checkbox 
    Then item "Reagent 6" is checked
    And icon "edit" is enabled in page
    When user select an item "Reagent 7" by check the checkbox
    Then item "Reagent 7" is checked
    When user clicks on "edit" icon
    Then user is navigated to "Edit Reagent" page
    When user "change" "Reagent 6.0" in "name" textbox
    And user "change" "Reagent 6.0 with Antibiotic" in "notes" textbox
    And user clicks on "Save" button 
    Then modal "Save Confirm" confirmation is displayed
    When user clicks on "OK" button
    Then notification "Success" and "Reagent has been updated" is displayed
    When user clicks on "next" icon 
    When user "change" "Reagent 7.0" in "name" textbox
    And user "change" "Reagent 7.0 with Antibiotic" in "notes" textbox
    And user clicks on "Save" button 
    Then modal "Save Confirm" confirmation is displayed
    When user clicks on "OK" button
    Then notification "Success" and "Reagent has been updated" is displayed
    When user clicks on "close" icon 
    And user is navigated to "Reagent Library" page
    And item "Reagent 6" change to be "Reagent 6.0"
    And item "Reagent 7" change to be "Reagent 7.0"