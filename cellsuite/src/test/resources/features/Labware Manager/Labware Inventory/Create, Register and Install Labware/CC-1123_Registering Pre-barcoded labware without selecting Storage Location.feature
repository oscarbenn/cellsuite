@CC-1123_Registering_Pre-barcoded_labware_without_selecting_Storage_Location
Feature: CC-1123:Registering Pre-barcoded labware without selecting Storage Location

    this feature to verify that system not allowing user to register a pre-barcoded labware without selecting the Storage Location
    
    Background: User has logged in on Cell Suite application and is on Labware Invenntory page
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Labware"
    And user clicks on sub-menu "Inventory"
    Then user is navigated to "Inventory" page

    Scenario: Register a pre-barcoded labware without selecting Storage Location
    When user clicks on "Register" button
    Then user is navigated to "Register Inventory" page
    When user select "Trough 250" in dropdown "Labware"
    Then dropdown "Labware" is filled by "Trough 250"
    When user select "Empty" in dropdown "Content Type"
    Then dropdown "Content Type" is filled by "Empty"
    And box "Labware Count" is "appear"
    When user select "Prebarcoded" radio
    Then radio "Prebarcoded" is selected
    And box "Labware Count" is "disabled"
    When user clicks on "Save" button
    Then notification "Warning" and "Storage location is required" is displayed