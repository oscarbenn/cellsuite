@reagentlibrary
@CC-1080_Create_new_Reagent
Feature: CC-1080:Create new reagent

    This test case is to make sure the user could create new Reagent item

    Background: User is on Reagent menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Library"
    Then user is navigated to "Reagent Library" page

    Scenario: create new reagent item
    When user clicks on "Create" button
    Then user is navigated to "Create Reagent" page
    When user fill the form in Create Reagent page with this data
    |nama|type|note|
    |Reagent 1|Antibiotic|Create Reagent 1 with Antibiotic|
    Then all fields in Create Reagent page is filled with this data
    |nama|type|note|
    |Reagent 1|Antibiotic|Create Reagent 1 with Antibiotic|
    When user clicks on "Save" button
    And notification "Success" and "Reagent has been created" is displayed
    And there is "new" item "Reagent 1" created in table
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Culture Reagent"
    Then user is navigated to "Culture Reagent" page
    And there is "no new" item "Reagent 1" created in table