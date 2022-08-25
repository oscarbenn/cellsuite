@reagentculture
@CC-1132_Edit_One_Culture_Reagent_Item
Feature: CC-1132: Edit One Culture Reagent Item

    This test case is to make sure the user could edit Culture Reagent item.

    Background: User is on Culture Reagent menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Culture Reagent"
    Then user is navigated to "Culture Reagent" page
    And "Reagent 7 Culture" items is "already" exist

    Scenario: Select and Edit an culture reagent item
    When user select an item "Reagent 7 Culture" by check the checkbox
    Then item "Reagent 7 Culture" is checked
    And icon "edit" is enabled in page
    When user clicks on "edit" icon
    Then user is navigated to "Edit Culture Reagent" page
    When user "change" "Reagent 7.0 Culture " in "name" textbox
    And user "change" "Create Reagent 7.0  Culture" in "notes" textbox

    When user select reagent compotition "Trypsin" and type "100" in persentage
    Then composition reagent selected is "Trypsin" 
    And accepted total volume of reagent is "100"

    And user clicks on "Save" button
    Then modal "Save Confirm" confirmation is displayed
    When user clicks on "OK" button
    Then notification "Success" and "Culture Reagent has been updated" is displayed
    And user is navigated to "Culture Reagent" page
    # And reagent is updated and saved with name "Reagent 7.0" and note "Reagent 3.0 with Antibiotic"
    