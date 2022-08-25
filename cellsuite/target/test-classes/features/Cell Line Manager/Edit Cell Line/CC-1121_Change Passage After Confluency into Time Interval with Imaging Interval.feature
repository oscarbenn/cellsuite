@cellline
@CC-1121_Change_Passage_After_Confluency_into_Time_Interval_with_Imaging_Interval
Feature: CC-1121:Change Passage After Confluency into Time Interval with Imaging Interval

    Feature Description
    Background: User has logged in on Cell Suite application and is on Cell Line menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Cell Line"
    Then user is navigated to "Cell Line" page
    And "my cell 8" items is "already" exist

    Scenario: Edit
    When user select an item "my cell 8" by check the checkbox
    Then item "my cell 8" is checked
    And icon "edit" is enabled in page
    When user clicks on "edit" icon
    Then user is navigated to "Edit Cell Lines" page
    When user "change" "my cell 8.0 edit" in "name" textbox
    When user select "Time Interval" radio
    Then radio "Time Interval" is selected
    And checkbox "Imaging Interval" is enable
    When user type cell line time interval as "78"
    Then cell line time interval is filled by "78"
    When user clicks to check on "Imaging Interval" checkbox
    When user type on box Imaging Interval as "12"
    Then box Imaging Interval filled by "12"
    And user clicks on "Save" button
    Then modal "Save Confirm" confirmation is displayed
    When user clicks on "OK" button
    Then notification "Success" and "Cell Lines has been updated" is displayed
    And user is navigated to "Cell Line" page
    When user clicks detail button of item "my cell 8.0 edit"
    Then data new cell line will show
    | Name | Organism | Tissue | Morphology | Disease | Notes | Passage After | Media Selection | Media Replacement | Detachment Reagent | Detachment Reagent Volume | Detachment Reagent Incubation Time | Passage Ratio | Adhering Time | Using Imaging | Estimated Doubling Time | Cell Density/cm2 | Cell Dilution Ratio | Dye Dilution Ratio |
    | my cell 8.0 edit | Mouse | Embryo | Fibroblast | mimic human liver | sample cell from mouse liver | 78 hour(s) | DMEM FBS 10 | 100% | Trypsin | 600.0 µL | 15 minute(s) | 1 : 3 | 6 hour(s) | Yes | 48 hour(s) | 90000 x104 | 1 | 1 |
