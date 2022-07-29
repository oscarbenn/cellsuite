@reagentFeature
Feature: CRUD Reagent

    this feature to check functionality of CRUD Reagent

    Background: user is logged 
    Given user is navigated to website "http://localhost:5050"
    Then user is on "login" page
    When user enters username as "admin"
    And user enters password as "admin"
    And user clicks on "SignIn" button
    Then user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Library"
    Then user is navigated to "Reagent Library" page

    Scenario: create new reagent
    When user clicks on "Create Reagent" button
    Then user is redirected into "Create Reagent" page
    When user type reagent "name" as "Reagent 1"
    Then "Reagent 1" is typed on "name" textbox
    When user select "Antibiotic" on "type" 
    Then "Antibiotic" is selected on "type"
    When user type reagent "note" as "Create Reagent 1 with Antibiotic"
    Then "Create Reagent 1 with Antibiotic" is typed on "note" textbox
    When user clicks on "Save" button
    Then new "reagent" item is created with notification "Success"
    And There is no new "culture reagent" item created

    


