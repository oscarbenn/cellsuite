@reagentlibrary
Feature: delete reagent 1.0,,6.0,7.0, reagent 2 culture

    Background: User is on Reagent menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Library"
    Then user is navigated to "Reagent Library" page

    Scenario: Select and Delete an reagent item
    When user select an item "Reagent 1.0" by check the checkbox 
    Then item "Reagent 1.0" is checked 
    And icon "delete" is enabled in page
    When user select an item "Reagent 6.0" by check the checkbox 
    Then item "Reagent 6.0" is checked
    When user select an item "Reagent 7.0" by check the checkbox 
    Then item "Reagent 7.0" is checked 
    When user clicks on "delete" icon
    Then modal "Delete reagents" confirmation is displayed
    When user clicks on "OK" button in modal
    Then notification "Success" and "Reagents has been deleted" is displayed

    When user refresh the browser page
    Then user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Culture Reagent"
    Then user is navigated to "Culture Reagent" page
    And "Reagent 2 Culture" items is "already" exist
    When user select an item "Reagent 2 Culture" by check the checkbox
    Then item "Reagent 2 Culture" is checked
    And icon "delete" is enabled in page
    When user clicks on "delete" icon
    Then modal "Delete Culture Reagent" confirmation is displayed
    When user clicks on "OK" button in modal
    Then notification "Success" and "Culture Reagents has been deleted" is displayed

    When user refresh the browser page
    And user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Library"
    Then user is navigated to "Reagent Library" page
    When user select an item "Reagent 2 Culture" by check the checkbox 
    Then item "Reagent 2 Culture" is checked 
    And icon "delete" is enabled in page
    When user clicks on "delete" icon
    Then modal "Delete reagents" confirmation is displayed
    When user clicks on "OK" button in modal
    Then notification "Success" and "Reagents has been deleted" is displayed

