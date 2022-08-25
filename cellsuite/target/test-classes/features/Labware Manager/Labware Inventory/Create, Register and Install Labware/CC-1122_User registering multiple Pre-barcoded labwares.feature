@CC-1122
Feature: CC-1122:User registering multiple Pre-barcoded labwares

    this feature to check functionality of Labware Inventory
    Background: User has logged in on Cell Suite application and is on Labware Invenntory menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Labware"
    And user clicks on sub-menu "Inventory"
    Then user is navigated to "Inventory" page
    # And data table show up

    Scenario: Create New Cell Line
    When user clicks on "Register" button
    Then user is navigated to "Register Inventory" page