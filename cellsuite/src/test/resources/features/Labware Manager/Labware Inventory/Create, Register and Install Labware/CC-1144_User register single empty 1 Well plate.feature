@CC-1144_User_register_single_empty_one_Well_plate
Feature: CC-1144:User register single empty one Well plate 

    this feature to verify that system allow user to register Empty 1 Well Plate to the system
    
    Background: User has logged in on Cell Suite application and is on Labware Invenntory page
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Labware"
    And user clicks on sub-menu "Library"
    Then user is navigated to "Labware Library" page
    And "SBS One Well" items is "already" exist
    And user clicks on sub-menu "Inventory"
    Then user is navigated to "Inventory" page

    Scenario: User register single empty 1 Well plate
    When user clicks on "Register" button
    Then user is navigated to "Register Inventory" page
    When user select "SBS One Well" in dropdown "Labware"
    Then dropdown "Labware" is filled by "SBS One Well"
    And user select "Empty" in dropdown "Content Type"
    Then dropdown "Content Type" is filled by "Empty"
    When user select "Generate by system" radio
    Then radio "Generate by system" is selected
    And user clicks on "Save" button
    Then notification "Success" and "Labware has been registered" is displayed
    And modal "Save Labware" confirmation is displayed
    When user clicks button OK in modal Save Labware
    Then user is navigated to "Inventory" page
    And there is new item "SBS One Well" created in table with empty exp date
    