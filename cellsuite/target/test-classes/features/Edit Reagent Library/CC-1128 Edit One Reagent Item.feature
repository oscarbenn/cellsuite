@CC-1128_Edit_one_reagent_item
Feature: CC-1128:Edit one reagent item

    This test case is to make sure the user could edit Reagent item.

    Background: User is on Reagent menu
    Given user is navigated to website
    Then user is navigated to "login" page
    When user enters username as "admin"
    And user enters password as "admin"
    And user clicks on "SignIn" button
    Then user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Library"
    Then user is navigated to "Reagent Library" page
    And Reagent items is already exist

    Scenario: Select and Edit an reagent item
    
