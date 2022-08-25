@reagentculture
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
    When user clicks on "Create" button
    Then user is navigated to "Create Culture Reagent" page
    When user "type" "Reagent 10 Culture" in "name" textbox
    Then textbox "name" will fill by "Reagent 10 Culture"
    When user "type" "create culture reagent 10" in "notes" textbox
    Then textbox "notes" will fill by "create culture reagent 10"

    When user select reagent compotition "DMEM High Glucose" and type "100" in persentage
    Then composition reagent selected is "DMEM High Glucose" 
    And accepted total volume of reagent is "100"

    When user clicks on "Save" button
    Then notification "Success" and "Culture Reagent has been created" is displayed
    And there is "new" item "Reagent 10 Culture" created in table
    