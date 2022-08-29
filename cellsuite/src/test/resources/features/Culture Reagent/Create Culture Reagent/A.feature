@reagentculture
@A
Feature: CC-1101: prekondisi

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
    When user "type" "Reagent 7 Culture" in "name" textbox
    Then textbox "name" will fill by "Reagent 7 Culture"
    When user "type" "create culture reagent 7" in "notes" textbox
    Then textbox "notes" will fill by "create culture reagent 7"
    When user select reagent compotition "DMEM High Glucose" and type "100" in persentage
    Then composition reagent selected is "DMEM High Glucose" 
    And accepted total volume of reagent is "100"
    When user clicks on "Save" button
    Then notification "Success" and "Culture Reagent has been created" is displayed
    And there is "new" item "Reagent 7 Culture" created in table

    When user clicks on "Create" button
    Then user is navigated to "Create Culture Reagent" page
    When user "type" "Reagent 8 Culture" in "name" textbox
    Then textbox "name" will fill by "Reagent 8 Culture"
    When user "type" "create culture reagent 8" in "notes" textbox
    Then textbox "notes" will fill by "create culture reagent 8"
    When user select reagent compotition "DMEM High Glucose" and type "100" in persentage
    Then composition reagent selected is "DMEM High Glucose" 
    And accepted total volume of reagent is "100"
    When user clicks on "Save" button
    Then notification "Success" and "Culture Reagent has been created" is displayed
    And there is "new" item "Reagent 8 Culture" created in table

    When user clicks on "Create" button
    Then user is navigated to "Create Culture Reagent" page
    When user "type" "Reagent 9 Culture" in "name" textbox
    Then textbox "name" will fill by "Reagent 9 Culture"
    When user "type" "create culture reagent 9" in "notes" textbox
    Then textbox "notes" will fill by "create culture reagent 9"
    When user select reagent compotition "DMEM High Glucose" and type "100" in persentage
    Then composition reagent selected is "DMEM High Glucose" 
    And accepted total volume of reagent is "100"
    When user clicks on "Save" button
    Then notification "Success" and "Culture Reagent has been created" is displayed
    And there is "new" item "Reagent 9 Culture" created in table