@CC-1143_User_register_multiple_empty_96_Wells_plate
Feature: CC-1143:User register multiple empty 96 Wells plate

    this feature to verify that system allow user to register multiple Empty 96 Wells Plate to system

    Background: User has logged in on Cell Suite application and is on Labware Invenntory page
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Labware"
    And user clicks on sub-menu "Library"
    Then user is navigated to "Labware Library" page
    And "SBS 96 Wells" items is "already" exist
    And user clicks on sub-menu "Inventory"
    Then user is navigated to "Inventory" page

    Scenario: User register multiple empty 96 Wells plate
    When user clicks on "Register" button
    Then user is navigated to "Register Inventory" page
    When user select "SBS 96 Wells" in dropdown "Labware"
    Then dropdown "Labware" is filled by "SBS 96 Wells"
    And user select "Empty" in dropdown "Content Type"
    Then dropdown "Content Type" is filled by "Empty"
    When user fill on Labware Count as "2"
    Then Labware Count is filled by "2"
    When user select "Generate by system" radio
    Then radio "Generate by system" is selected
    When user type "SBS 96 Wells Empty" in notes textbox
    Then textbox notes is filled by "SBS 96 Wells Empty"
    And user clicks on "Save" button
    Then notification "Success" and "Labware has been registered" is displayed
    And modal "Save Labware" confirmation is displayed
    When user clicks button OK in modal Save Labware
    Then user is navigated to "Inventory" page
    And there is new item "SBS 96 Wells" created in table with empty exp date