Feature: TIMESHEET

  Background: Timesheet
    Given To Check Timesheet user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When To Check Timesheet Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@123"
    And Click the Login button To Check Timesheet
    Then Click Timesheet button in the menu bar

  @TC_01
  Scenario: Enter Timesheet:Week Check
    Given Click Enter Timesheet button in the menu bar
    When Click previous week button in Enter Timesheet
    And Click next week button in Enter Timesheet
    Then Click Today button in Enter Timesheet
    Then Close Timesheet page
    
    @TC_02
  Scenario: Enter Timesheet:Add New Event:Close Check
    Given Click Enter Timesheet button in the menu bar
    When Click Add new new button in the menu bar
    Then Click close button in Add event popup
    Then Close Timesheet page
    
    @TC_03
  Scenario: Enter Timesheet:Add New Event:Mandatory Check
    Given Click Enter Timesheet button in the menu bar
    When Click Add new new button in the menu bar
    Then Click save button in Add event popup
    And Check mandatory message is displayed or not in Add event popup
    Then Close Timesheet page
    
    @TC_04
  Scenario: Enter Timesheet:Add New Event:Clear Check
    Given Click Enter Timesheet button in the menu bar
    When Click Add new new button in the menu bar
    Then Select valid project "Automation Testing" in Add event popup
    And Select valid issue "AT-03 - Tests" in Add event popup
    #Then Select valid Start time in Add event popup
    #Then Select valid End time in Add event popup
    Then Enter valid description "Test Description" in Add event popup
    And Click clear button in Add event popup
    Then Close Timesheet page
    
    @TC_05
  Scenario: Enter Timesheet:Add New Event:Save Check
    Given Click Enter Timesheet button in the menu bar
    When Click Add new new button in the menu bar
    Then Select valid project "Automation Testing" in Add event popup
    And Select valid issue "AT-03 - Tests" in Add event popup
    #And Select valid Start time in Add event popup
    #Then Select valid End time in Add event popup
    Then Enter valid description "Test Description" in Add event popup
    And Click save button in Add event popup
    And Check success message is displayed or not in Add event popup
    Then Close Timesheet page
    
    @TC_06
  Scenario: View Timesheet:Add New Event:Assignee Check
    Given Click View Timesheet button in the menu bar
    When Select valid assignee name "Thirumaran" in view timesheet
    Then Check entered name "Thirumaran" is displayed or not in view timesheet
    Then Close Timesheet page
    
    @TC_07
  Scenario: View Timesheet:Add New Event:Month Check
    Given Click View Timesheet button in the menu bar
    When Select valid month name "Last Month" in view timesheet
    Then Close Timesheet page
    
    @TC_08
  Scenario: View Timesheet:Add New Event:Project Name Check
    Given Click View Timesheet button in the menu bar
    When Select valid project name "CGI" in view timesheet
    Then Close Timesheet page
    
    @TC_09
  Scenario: View Timesheet:Add New Event:Export Check
    Given Click View Timesheet button in the menu bar
    When Click export button in view timesheet
    Then Close Timesheet page

     