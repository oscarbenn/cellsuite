@CC-1156_User_print_barcodes_for_multiple_labware
Feature: CC-1156:User print barcodes for multiple labware

    this feature to verify that system is able to printing barcodes for multiple labwares at once
    
    Background: User has logged in on Cell Suite application and is on Labware Invenntory page
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Labware"
    And user clicks on sub-menu "Inventory"
    Then user is navigated to "Inventory" page

    Scenario: print barcode for 3 labware
    When user clicks "3" labware with "Unknown" of "status"
    Then icon "printer" is enabled in page
    When user clicks on "printer" icon
    Then notification "Success" and "Barcode has been printed" is displayed