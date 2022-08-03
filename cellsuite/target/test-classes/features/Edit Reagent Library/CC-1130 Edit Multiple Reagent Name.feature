@CC-1130_Edit_multiple_reagent_item
Feature: CC-1130:Edit multiple reagent item

    This test case is to make sure the user could edit multiple Reagent items.

    Background: User is on Reagent menu
    Given user is navigated to website
    Then user is navigated to "login" page
    When user enters username as "admin"
    And user enters password as "admin"
    And user clicks on "SignIn" button
    Then user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Library"
    Then user is navigated to "Reagent Library" page
    And "Reagent" items is already exist

    Scenario: Select and Edit some reagent item
    When user select an "reagent" item "Reagent 44" by check the checkbox
    Then "reagent" checkbox "Reagent 44" item is checked
    When user select an "reagent" item "Reagent 11" by check the checkbox
    Then "reagent" checkbox "Reagent 11" item is checked
    And button "edit" "reagent" is enabled
    When user clicks on "edit reagent" button
    Then user is navigated to "Edit Reagent" page
    When user change "name" with "Reagent 4.0"
    And user change "note" with "Reagent 4.0 with Antibiotic"
    And user clicks on "save reagent" button
    Then modal "save" confirmation is displayed
    When user clicks on "Ok" button
    Then the "reagent" item is "updated" with notification "Success" and "Reagent has been updated"
    When user clicks on "arrow Next" button
    Then user is navigated to "Edit Reagent" page
    #And button "next" "reagent" is enabled
    When user change "name" with "Reagent 1.0"
    And user change "note" with "Reagent 1.0 with Antibiotic"
    And user clicks on "save reagent" button
    Then modal "save" confirmation is displayed
    When user clicks on "Ok" button
    Then the "reagent" item is "updated" with notification "Success" and "Reagent has been updated"
    When user clicks on "close" button
    #Then "Edit Reagent" page is closed
    And user is navigated to "Reagent Library" page
    #And reagent is updated and saved with name "Reagent 1.0" and note "Reagent 1.0 with Antibiotic"
    