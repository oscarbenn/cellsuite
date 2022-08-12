@CC-1043_Create_new_Cell_Line_by_filling_all_fields
Feature: CC-1043:Create new Cell Line by filling all fields

    This test case is to make sure if user could create new Cell Line if they fill all the fields

    Background: User is on Reagent menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Cell Line"
    Then user is navigated to "Cell Line" page

    Scenario: create new Cell Line
    When user clicks on "create" button in page
    Then user is navigated to "Create Cell Lines" page
    When user fill all the fields according to its data type on create cell lines page
    | Name | Organism | Tissue | Morphology | Disease | Notes | PassageAfter | PassageAfterValue | MediaSelection | MediaReplacement | FeedingInterval | DetachmentReagent | DetachmentReagentVolume | DetachmentReagentIncubationTime | PassageRadio | AdheringTime | Imaging Interval | EstimatedDoublingTim | CellDensity | CellRatio | DyeRatio |
    | Cell Line 1 | Mouse | Liver | Epithelial | Disease 1 | create cell lines 1 with all fields is filled | confluency | 80 | DMEM FBS 10 | 100% | 48 | Trypsin | 6000 | 15 | 3 | 6 | 48 | 48 | 9 | 1 | 1 |
    Then all fields is filled with data which typed
    | Name | Organism | Tissue | Morphology | Disease | Notes | PassageAfter | PassageAfterValue | MediaSelection | MediaReplacement | FeedingInterval | DetachmentReagent | DetachmentReagentVolume | DetachmentReagentIncubationTime | PassageRadio | AdheringTime | Imaging Interval | EstimatedDoublingTim | CellDensity | CellRatio | DyeRatio |
    | Cell Line 1 | Mouse | Liver | Epithelial | Disease 1 | create cell lines 1 with all fields is filled | confluency | 80 | DMEM FBS 10 | 100% | 48 | Trypsin | 6000 | 15 | 3 | 6 | 48 | 48 | 9 | 1 | 1 |
    When user clicks on "save" button in page
    Then notification "Success" and "Cell lines has been created" is displayed
    And there is new "cell line" item created