@CC-1161_User_attemtp_to_print_prebarcoded_and_non-prebarcoded_labware_at_once
Feature: CC-1161:User attemtp to print prebarcoded and non-prebarcoded labware at once

    this feature to verify that system will not let the user to print barcode when user selecting prebarcoded and system generate labware together

    Background: User has logged in on Cell Suite application and is on Labware Invenntory page
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Labware"
    And user clicks on sub-menu "Inventory"
    Then user is navigated to "Inventory" page

    Scenario: print barcode when user selecting prebarcoded and system generate labware together
    When user clicks "1" labware with "00000" of "barcode"
    When user clicks "1" labware with "#WAITING" of "barcode"
    Then icon "printer" is disabled in or unavailable