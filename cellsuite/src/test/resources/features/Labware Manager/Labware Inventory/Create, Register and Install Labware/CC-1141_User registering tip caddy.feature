@CC-1141_User_registering_tip_caddy
Feature: CC-1141:User registering tip caddy

    this feature to verify that system allow user to register Tip caddy to the system.
    
    Background: User has logged in on Cell Suite application and is on Labware Invenntory page
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Labware"
    And user clicks on sub-menu "Library"
    Then user is navigated to "Labware Library" page
    And "Tip Caddy F1000" items is "already" exist
    And user clicks on sub-menu "Inventory"
    Then user is navigated to "Inventory" page

    Scenario: User registering tip caddy
    When user clicks on "Register" button
    Then user is navigated to "Register Inventory" page
    When user select "Tip Caddy F1000" in dropdown "Labware"
    Then dropdown "Labware" is filled by "Tip Caddy F1000"
    And dropdown "Content Type" is filled by "Tip"
    And box "Tip Amount" is "appear"
    # And "Create Content" menu is appear
    When user fill on "Tip Amount" as "96"
    Then "Tip Amount" is filled by "96"
    And user clicks on "Save" button
    Then notification "Success" and "Labware has been registered" is displayed
    And modal "Save Labware" confirmation is displayed
    When user clicks button OK in modal Save Labware
    Then user is navigated to "Inventory" page
    And There is new "1" data with this condition
    | Labware Name | ContentType | Location | Status |
    | Tip Caddy F1000 | Tip | Outside of the System | Unknown |

    
    