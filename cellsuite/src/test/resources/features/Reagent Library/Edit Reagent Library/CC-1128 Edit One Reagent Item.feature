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
    And reagent items is already exist

    Scenario: Select and Edit an reagent item
    When user select an reagent item "Reagent 3" by check the checkbox
    Then reagent checkbox "Reagent 3" item is checked
    And icon "edit" is enabled in page
    When user clicks on "edit" icon in page
    Then user is navigated to "Edit Reagent" page
    When user change "name" with "Reagent 3.0"
    And user change "note" with "Reagent 3.0 with Antibiotic"
    And user clicks on "save" button in page
    Then modal "Save Confirm" confirmation is displayed
    When user clicks on "OK" button in modal
    Then notification "Success" and "Reagent has been updated" is displayed
    And reagent is updated and saved with name "Reagent 2.0" and note "Reagent 2.0 with Antibiotic"
    And user is navigated to "Reagent Library" page