@reagentFeature
Feature: CRUD Reagent

    this feature to check functionality of CRUD Reagent

    Background: user is logged 
    Given user is navigated to website "http://localhost:5050"
    Then user is navigated to "login" page
    When user enters username as "admin"
    And user enters password as "admin"
    And user clicks on "SignIn" button
    Then user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Library"
    Then user is navigated to "Reagent Library" page
    When user clicks on "Create Reagent" button
    Then user is navigated to "Create Reagent" page

    Scenario: create new reagent
    When user type reagent "name" as "Reagent 1"
    Then "Reagent 1" is typed on "name" textbox
    When user select "Antibiotic" on "type" 
    Then "Antibiotic" is selected on "type"
    When user type reagent "note" as "Create Reagent 1 with Antibiotic"
    Then "Create Reagent 1 with Antibiotic" is typed on "note" textbox
    When user clicks on "Save" button
    Then new "reagent" item is created with notification "Success" and "Reagent has been created"
    And There is no new "culture reagent" item created

    @withCreateCultureReagent
    Scenario: create new reagent with create culture reagent
    When user type reagent "name" as "Reagent 2"
    Then "Reagent 2" is typed on "name" textbox
    When user select "Antibiotic" on "type" 
    Then "Antibiotic" is selected on "type"
    When user check "create culture reagent" on checkbox
    Then checkbox "create culture reagent" is checked
    When user type reagent "note" as "Create Reagent 1 with Antibiotic"
    Then "Create Reagent 1 with Antibiotic" is typed on "note" textbox
    When user clicks on "Save" button
    Then new "reagent" item is created with notification "Success" and "Reagent has been created"
    And There is new "culture reagent" item created with "100%" composition




