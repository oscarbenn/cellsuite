@CC-1163_User_delete_multiple_unused_labware
Feature: CC-1163:User delete multiple unused labware

    this feature to verify that system can delete multiple unused labware at once

    Background: User has logged in on Cell Suite application and is on Labware Invenntory page
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Labware"
    And user clicks on sub-menu "Inventory"
    Then user is navigated to "Inventory" page

    Scenario: deleting single unused labware
    When user clicks "2" labware with "Unknown" of "status"
    When user click on more icon button and click " Delete" menu
    Then modal "Delete Labware" confirmation is displayed
    And user clicks on "OK" button
    Then notification "Success" and "Inventories has been deleted" is displayed
