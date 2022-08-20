@CC-1119_Change_from_Time_Interval_with_Imaging_Interval_to_Confluency
Feature: CC-1119:Change from Time Interval (with Imaging Interval) to Confluency

    Feature Description
    Background: User has logged in on Cell Suite application and is on Cell Line menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Cell Line"
    Then user is navigated to "Cell Line" page
    And "my cell 4" items is "already" exist


    Scenario: Edit
    When user select an item "my cell 4" by check the checkbox
    Then item "my cell 4" is checked
    And icon "edit" is enabled in page
    When user clicks on "edit" icon
    Then user is navigated to "Edit Cell Lines" page
    When user "change" "my cell 4.0 edit" in "name" textbox

    When user select "confluency" radio
    Then radio "confluency" is selected
    And checkbox "Imaging Interval" is disable
    When user type cell line confluency as "80"
    Then cell line confluency is filled by "80"
    When user type on box Imaging Interval as "48"
    Then box Imaging Interval filled by "48"
    And user clicks on "save" button
    Then modal "Save Confirm" confirmation is displayed
    When user clicks on "OK" button in modal
    Then notification "Success" and "Cell Lines has been updated" is displayed
    And user is navigated to "Cell Line" page
    When user clicks detail button of item "my cell 4.0 edit"
    And user validating data new cell line
    | Name | Organism | Tissue | Morphology | Disease | Notes | Passage After | Media Selection | Media Replacement | Detachment Reagent | Detachment Reagent Volume | Detachment Reagent Incubation Time | Passage Ratio | Adhering Time | Using Imaging | Estimated Doubling Time | Cell Density/cm2 | Cell Dilution Ratio | Dye Dilution Ratio |
    | my cell 4.0 edit | Mouse | Embryo | Fibroblast | mimic human liver | sample cell from mouse liver | 80% Confluency | DMEM FBS 10 | 100% | Trypsin | 600.0 µL | 15 minute(s) | 1 : 3 | 6 hour(s) | Yes | 48 hour(s) | 90000 x104 | 1 | 1 |
