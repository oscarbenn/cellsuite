@CC-1166_User_cancel_delete_labware
Feature: CC-1166:User cancel delete labware

    this feature to verify that system allowing user to cancel deleting labware

    Background: User has logged in on Cell Suite application and is on Labware Invenntory page
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Labware"
    And user clicks on sub-menu "Inventory"
    Then user is navigated to "Inventory" page

    Scenario: deleting single unused labware
    When user clicks "1" labware with "Unknown" of "status"
    When user click on more icon button and click " Delete" menu
    Then modal "Delete Labware" confirmation is displayed
    And user clicks on "Cancel" button
    Then modal confirmation is closed