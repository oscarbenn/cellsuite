@CC-1052_Delete_Cell_Line_which_already_used_in_inventory
Feature: CC-1052:Delete Cell Line which already used in inventory

    this feature to check functionality of CRUD Cell Line
    
    Background: User has logged in on Cell Suite application and is on Cell Line menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Cell Line"
    Then user is navigated to "Cell Line" page

    Scenario: Delete Cell Line
    When user select all item
    Then icon "delete" is enabled in page
    When user clicks on "delete" icon
    Then modal "Delete Cell Lines" confirmation is displayed
    When user clicks on "OK" button in modal
    Then notification "One or more validation errors occurred." and "Can't delete, data is still used in InventoryContent." is displayed
    