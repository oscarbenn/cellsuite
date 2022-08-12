@CC-1102_Create_new_Culture_Reagent
Feature: CC-1102:Create new Culture Reagent

    This test case is to make sure if user could create new Reagent Culture item

    Background: User is on Reagent Culture menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Culture Reagent"
    Then user is navigated to "Culture Reagent" page

    Scenario: user create new culture reagent item
    When user clicks on "create" button in page
    Then user is navigated to "Create Culture Reagent" page
    When user type on "name" textbox Culture Reagent as "Reagent 10 culture"
    Then "name" textbox in page Create Culture Reagent filled by "Reagent 10 culture"
    When user select reagent compotition "Trypan-Blue" and type "100" in persentage
    Then composition reagent selected is "Trypan-Blue"
    And accepted total volume of reagent is "100%"
    When user type on "notes" textbox Culture Reagent as "create culture reagent 10"
    Then "notes" textbox in page Create Culture Reagent filled by "create culture reagent 10"
    When user clicks on "Save" button in Create Culture Reagent page
    Then new Culture Reagent item is created with named is "Reagent 10"
    And notification "Success" and "Culture Reagent has been created" is displayed
    