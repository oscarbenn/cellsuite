@CC-1166
Feature: CC-1166:User cancel delete labware

    this feature to check functionality of Labware Inventory
    Background: User has logged in on Cell Suite application and is on Labware Invenntory menu
    Given user is navigated to website "http://localhost:5050"
    Then user is navigated to "Login" page
    Then user is navigated to "Login" page
    When user enters "Username" as "admin"
    Then "admin" is typed on "Username" textbox
    When user enters "Password" as "admin"
    Then "admin" is typed on "Password" textbox
    And user clicks on "SIGN IN" button
    Then user is navigated to "Dashboard" page
    When user clicks on menu "Labware"
    And user clicks on sub-menu "Inventory"
    Then user is navigated to "Inventory" page
    And data table show up

    Scenario: CC-1155:User print barcode for single labware
    When user check labware with "Unknown" barcode