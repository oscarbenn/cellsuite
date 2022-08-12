@reagentlibrary
@CC-1103_Create_new_reagent_with_new_culture_reagent
Feature: CC-1103:Create new reagent with new culture reagent

    This test case is to make sure if user could create new Reagent item and auto create Reagent Culture item.

    Background: User is on Reagent menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Library"
    Then user is navigated to "Reagent Library" page

    Scenario: Create new Reagent item
    When user clicks on "create" button in page
    Then user is navigated to "Create Reagent" page
    When user fill the form in Create Reagent page with this data
    |nama|type|note|
    |Reagent 4 Culture|Antibiotic|Create Reagent 4 with Antibiotic|
    Then all fields in Create Reagent page is filled with this data
    |nama|type|note|
    |Reagent 4 Culture|Antibiotic|Create Reagent 4 with Antibiotic|
    When user check "create culture reagent" on checkbox
    Then checkbox "create culture reagent" is checked
    When user clicks on "Save" button in page
    Then notification "Success" and "Reagent has been created" is displayed
    And There is new "culture reagent" item created with "100%" composition named as "Reagent 4 Culture"




