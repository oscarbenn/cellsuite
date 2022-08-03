@CC-1080_Create_new_reagent
Feature: CC-1080:Create new reagent

    This test case is to make sure the user could create new Reagent item

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

    Scenario: create new reagent item
    When user clicks on "Create Reagent" button
    Then user is navigated to "Create Reagent" page
    When user type reagent "name" as "Reagent 22"
    Then "Reagent 22" is typed on "name" textbox
    When user select "Antibiotic" on "type" 
    Then "Antibiotic" is selected on "type"
    When user type reagent "note" as "Create Reagent 1 with Antibiotic"
    Then "Create Reagent 1 with Antibiotic" is typed on "note" textbox
    When user clicks on "Save" button
    Then the "reagent" item is "created" with notification "Success" and "Reagent has been created"
    And There is no new "culture reagent" item created