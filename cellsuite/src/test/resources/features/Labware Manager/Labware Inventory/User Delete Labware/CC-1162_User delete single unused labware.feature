@CC-1162_User_delete_single_unused_labware
Feature: CC-1162:User delete single unused labware

    this feature to verified that system can deleting unused labware

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
    And user clicks on "OK" button
    Then notification "Success" and "Inventories has been deleted" is displayed


    




