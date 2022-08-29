@CC-1157_User_print_barcode_while_registering_labware
Feature: CC-1157:User print barcode while registering labwaregh

    this feature to verify that system able to save and printing the barcode for the labware at once
    
    Background: User has logged in on Cell Suite application and is on Labware Invenntory page
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Labware"
    And user clicks on sub-menu "Library"
    Then user is navigated to "Labware Library" page
    And "Trough 250" items is "already" exist
    And user clicks on sub-menu "Inventory"
    Then user is navigated to "Inventory" page
    
    Scenario: User registering empty trough and print barcode
    When user clicks on "Register" button
    Then user is navigated to "Register Inventory" page
    When user select "Trough 250" in dropdown "Labware"
    Then dropdown "Labware" is filled by "Trough 250"
    When user select "Empty" in dropdown "Content Type"
    Then dropdown "Content Type" is filled by "Empty"
    And "Labware Count" is filled by "1"
    Then radio "Generate by system" is selected
    And user clicks on "Save & Print Barcode" button
    Then notification "Success" and "Labware has been registered" is displayed
    # Then notification "Success" and "Barcode has been printed" is displayed
    And modal "Save Labware" confirmation is displayed
    When user clicks button OK in modal Save Labware
    Then user is navigated to "Inventory" page
    And There is new "1" data with this condition
    | Labware Name | ContentType | Exp Date | Location | Status |
    | Trough 250 | Empty | - | Outside of the System | Unknown |
    