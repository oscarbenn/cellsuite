@CC-1134_User_registering_empty_trough
Feature: CC-1134:User registering empty trough

    this feature to verify that system allow user to register empty trough to the system.
    
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
    
    Scenario: User registering empty trough
    When user clicks on "Register" button
    Then user is navigated to "Register Inventory" page
    When user select "Trough 250" in dropdown "Labware"
    Then dropdown "Labware" is filled by "Trough 250"
    When user select "Empty" in dropdown "Content Type"
    Then dropdown "Content Type" is filled by "Empty"
    # When user fill on Labware Count as "1"
    # Then Labware Count is filled by "1"
    # When user select "Generate by system" radio
    # Then radio "Generate by system" is selected
    # When user type "Trough 250 Empty" in notes textbox
    # Then textbox notes is filled by "Trough 250 Empty"
    And user clicks on "Save" button
    Then notification "Success" and "Labware has been registered" is displayed
    And modal "Save Labware" confirmation is displayed
    When user clicks button OK in modal Save Labware
    Then user is navigated to "Inventory" page
    And There is new "1" data with this condition
    | Labware Name | ContentType | Exp Date | Location | Status |
    | Trough 250 | Empty | - | Outside of the System | Unknown |
    



