@CC-1159_User_attempt_to_print_barcode_for_the_prebarcoded_labware
Feature: CC-1159:User attempt to print barcode for the prebarcoded labware

    this feature is to verify that system not allowing user to print barcode of prebarcoded labware

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

    Scenario: print barcode of prebarcoded labware
    When user clicks "1" labware with "00000" of "barcode"
    Then icon "printer" is disabled in or unavailable
    # Then notification "Success" and "Barcode has been printed" is displayed
