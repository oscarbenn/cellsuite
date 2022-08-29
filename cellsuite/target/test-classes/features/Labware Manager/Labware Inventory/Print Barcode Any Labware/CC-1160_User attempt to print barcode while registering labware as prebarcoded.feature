@CC-1160_User_attempt_to_print_barcode_while_registering_labware_as_prebarcoded
Feature: CC-1160:User attempt to print barcode while registering labware as prebarcoded

    this feature to verify that the option for Save & Print Barcode is disabled when user selecting prebarcoded labware
    
    Background: User has logged in on Cell Suite application and is on Labware Invenntory page
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Labware"
    And user clicks on sub-menu "Inventory"
    Then user is navigated to "Inventory" page

    Scenario: User print barcode while registering labwaregh
    When user clicks on "Register" button
    Then user is navigated to "Register Inventory" page
    When user select "Trough 250" in dropdown "Labware"
    Then dropdown "Labware" is filled by "Trough 250"
    When user select "Empty" in dropdown "Content Type"
    Then dropdown "Content Type" is filled by "Empty"
    And "Labware Count" is filled by "1"
    Then radio "Generate by system" is selected
    When user select "Prebarcoded" radio
    Then radio "Prebarcoded" is selected
    And box "Labware Count" is "disabled"
    When user choose Storage Location colnum "6" rownum "8"
    Then Storage Location colnum "6" rownum "8" is filled with "Selected" color
    And "Labware Count" is filled by "1"
    Then "Save & Print Barcode" button is not appear
