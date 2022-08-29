@CC-1155_User_print_barcode_for_single_labware
Feature: CC-1155:User print barcode for single labware

    this feature to verify that system allowing user to print single labware barcode from the Invenntory main menu
    
    Background: User has logged in on Cell Suite application and is on Labware Invenntory page
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Labware"
    And user clicks on sub-menu "Inventory"
    Then user is navigated to "Inventory" page

    Scenario: print barcode for single labware
    When user clicks "1" labware with "Unknown" of "status"
    Then icon "printer" is enabled in page
    When user clicks on "printer" icon
    Then notification "Success" and "Barcode has been printed" is displayed



