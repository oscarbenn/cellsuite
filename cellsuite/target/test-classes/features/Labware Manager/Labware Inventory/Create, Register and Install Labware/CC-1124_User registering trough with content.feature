@CC-1124_User_registering_trough_with_content
Feature: CC-1124:User registering trough with content

    this feature to verify that user can registering trough with content in it

    Background: User has logged in on Cell Suite application and is on Labware Invenntory menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Culture Reagent"
    Then user is navigated to "Culture Reagent" page
    And "RPMI 1640" items is "already" exist
    When user refresh the browser page
    Then user is navigated to "Dashboard" page
    When user clicks on menu "Labware"
    And user clicks on sub-menu "Inventory"
    Then user is navigated to "Inventory" page

    Scenario: User registering trough with content
    When user clicks on "Register" button
    Then user is navigated to "Register Inventory" page
    When user select "Trough 250" in dropdown "Labware"
    Then dropdown "Labware" is filled by "Trough 250"
    And user select "Reagent" in dropdown "Content Type"
    Then dropdown "Content Type" is filled by "Reagent"
    And "Create Content" menu is appear
    When user select "Generate by system" radio
    Then radio "Generate by system" is selected
    When user enter Exp Date day "7" mounth "Sep" year "2022"
    Then Expiration date is set by "2022-09-07"
    When user select "25°C (Room Temperature)" in dropdown "Stored Temperature"
    Then dropdown "Stored Temperature" is filled by "25°C (Room Temperature)"

    When user clicks on "Create Content" button
    Then dialog for defining "Add Content" is displayed
    When user choose content "RPMI 1640" and fill volume "250000" and clicks on well image 
    Then content selected as "RPMI 1640" and volume displayed as "250000" and image well is colored
    And user clicks on "OK" button
    And user clicks on "Save" button
    Then notification "Success" and "Labware has been registered" is displayed
    And modal "Save Labware" confirmation is displayed
    When user clicks button OK in modal Save Labware
    Then user is navigated to "Inventory" page
    And There is new "1" data with this condition
    | Labware Name | ContentType | Volume | Location | Status |
    | Trough 250 | Reagent | 250.0 mL | Outside of the System | Unknown |