Feature: REPORT

  Background: Report
    Given To Check Report user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When To Check Report Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@123"
    And Click the Login button To Check Report
    Then Click Report button in the menu bar

  @TC_01
  Scenario: Project Report:Time Filter
    Given Click Project Report button in the menu bar
    When Select valid time "Today" option in Project Report
    Then Close Report page

  @TC_02
  Scenario: Project Report:Time Filter
    Given Click Project Report button in the menu bar
    When Select valid project "Accounting" option in Project Report
    Then Close Report page

  @TC_03
  Scenario: Project Report:Time Filter
    Given Click Project Report button in the menu bar
    When Click view all issues button in Project Report
    And Check page landed to kanban board page or not from Project Report
    Then Close Report page

    @TC_04
  Scenario: Resource Report:Time Filter
    Given Click Resource Report button in the menu bar
    When Select valid time "Today" option in Resource Report
    Then Close Report page
    
    @TC_05
  Scenario: Resource Report:Time Filter
    Given Click Resource Report button in the menu bar
    When Select valid project "Accounting" option in Resource Report
    Then Close Report page
    
    @TC_06
  Scenario: Resource Report:Time Filter
    Given Click Resource Report button in the menu bar
    When Select valid assignee name "Thirumaran R" option in Resource Report
    Then Close Report page
    
    @TC_07
  Scenario: Resource Report:Time Filter
    Given Click Resource Report button in the menu bar
    When Select valid assignee name "Thirumaran R" option in Resource Report
    And Click export excel button in Resource Report
    Then Close Report page
    
    @TC_08
  Scenario: Budget Report:Time Filter
    Given Click Budget Report button in the menu bar
    When Select valid project "Accounting" option in Budget Report
    Then Close Report page