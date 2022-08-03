@CC-1103_Create_new_reagent_with_new_culture_reagent
Feature: CC-1103:Create new reagent with new culture reagent

    This test case is to make sure if user could create new Reagent item and auto create Reagent Culture item.

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

    Scenario: Create new Reagent item
    When user clicks on "Create Reagent" button
    Then user is navigated to "Create Reagent" page
    When user type reagent "name" as "Reagent 44"
    Then "Reagent 44" is typed on "name" textbox
    When user select "Antibiotic" on "type" 
    Then "Antibiotic" is selected on "type"
    When user check "create culture reagent" on checkbox
    Then checkbox "create culture reagent" is checked
    When user type reagent "note" as "Create Reagent 1 with Antibiotic"
    Then "Create Reagent 1 with Antibiotic" is typed on "note" textbox
    When user clicks on "Save" button
    Then the "reagent" item is "created" with notification "Success" and "Reagent has been created"
    And There is new "culture reagent" item created with "100%" composition




