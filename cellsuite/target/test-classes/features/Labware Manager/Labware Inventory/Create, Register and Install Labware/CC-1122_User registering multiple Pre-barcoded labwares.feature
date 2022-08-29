@CC-1122_User_registering_multiple_Pre-barcoded_labwares
Feature: CC-1122:User registering multiple Pre-barcoded labwares

    this feature to verify that system allowing user to register multiple pre-barcoded labware at once

    Background: User has logged in on Cell Suite application and is on Labware Invenntory page
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Labware"
    And user clicks on sub-menu "Inventory"
    Then user is navigated to "Inventory" page

    Scenario: Register multiple pre-barcoded labware at once
    When user clicks on "Register" button
    Then user is navigated to "Register Inventory" page
    When user select "Trough 250" in dropdown "Labware"
    Then dropdown "Labware" is filled by "Trough 250"
    When user select "Empty" in dropdown "Content Type"
    Then dropdown "Content Type" is filled by "Empty"
    And box "Labware Count" is "appear"
    When user select "Prebarcoded" radio
    Then radio "Prebarcoded" is selected
    And box "Labware Count" is "disabled"
    When user choose Storage Location colnum "6" rownum "8"
    Then Storage Location colnum "6" rownum "8" is filled with "Selected" color
    And "Labware Count" is filled by "1"
    When user choose Storage Location colnum "1" rownum "8"
    Then Storage Location colnum "1" rownum "8" is filled with "Selected" color
    And "Labware Count" is filled by "2"
    When user clicks on "Save" button
    Then notification "Success" and "Labware has been registered" is displayed
    And modal "Save Labware" confirmation is displayed
    When user clicks button OK in modal Save Labware
    Then user is navigated to "Inventory" page
    And There is new "2" data with this condition
    | Barcode | Location | Status |
    | #WAITING | Outside of the System | Unknown |
     
    