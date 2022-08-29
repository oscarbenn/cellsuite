@CC-1154_User_cancel_register_labware
Feature: CC-1154:User cancel register labware

    this feature to verify that user can cancel registering labware

    Background: User has logged in on Cell Suite application and is on Labware Invenntory page
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Labware"
    And user clicks on sub-menu "Inventory"
    Then user is navigated to "Inventory" page

    Scenario: User cancel registering labware
    When user clicks on "Register" button
    Then user is navigated to "Register Inventory" page
    When user select "Trough 250" in dropdown "Labware"
    Then dropdown "Labware" is filled by "Trough 250"
    When user select "Empty" in dropdown "Content Type"
    Then dropdown "Content Type" is filled by "Empty"
    And box "Labware Count" is "appear"
    And "Labware Count" is filled by "1"
    And radio "Generate by system" is selected
    And user clicks on "close" icon
    And modal "Back to Inventory Management Overview" confirmation is displayed
    And user clicks on "OK" button
