Feature: RELEASE

  Background: Release
    Given To Check Release user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When To Check Release Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@123"
    And Click the Login button To Check Release
    Then Click Release button in the menu bar

  @TC_01
  Scenario: Release:Search Check
    Given Click Release screen button in the menu bar
    When Enter valid release version name "V2.1" in Release screen
    And Check entered release name "V2.1" is displayed or not in Release screen
    Then Close Release page

  @TC_02
  Scenario: Release:Date Check
    Given Click Release screen button in the menu bar
    When Select valid from date "01-01-2025" in Release screen
    And Select valid to date "01-01-2026" in Release screen
    Then Close Release page

  @TC_03
  Scenario: Release:Project Check
    Given Click Release screen button in the menu bar
    When Select valid project name "CGI" in Release screen
    Then Close Release page

  @TC_04
  Scenario: Release:Status Check
    Given Click Release screen button in the menu bar
    When Select valid status name "Initiated" in Release screen
    Then Close Release page

  @TC_05
  Scenario: Release:Add New:Close Check
    Given Click Release screen button in the menu bar
    When Click add new button in Release screen
    And Click close button in add Release popup
    Then Close Release page

  @TC_06
  Scenario: Release:Add New:Mandatory Check
    Given Click Release screen button in the menu bar
    When Click add new button in Release screen
    And Click save button in add Release popup
    Then Check mandatory message is displayed or not in add Release popup
    Then Close Release page

  @TC_07
  Scenario: Release:Add New:Clear Check
    Given Click Release screen button in the menu bar
    When Click add new button in Release screen
    And Enter valid release version name in add Release popup
    Then Select valid Project name "Automation Testing" in add Release popup
    And Select valid task option "AT-04 - Testing summary @123" in add Release popup
    Then Select valid start date "1" in add Release popup
    And Select valid release date "15" in add Release popup
    Then Select valid release start time "10" and "30" and "A" in add Release popup
    And Select valid release end time "12" and "30" and "P" in add Release popup
    Then Enter valid description "Test Description" in add Release popup
    And Click clear button in add Release popup
    Then Close Release page

  @TC_08
  Scenario: Release:Add New:Save Check
    Given Click Release screen button in the menu bar
    When Click add new button in Release screen
    And Enter valid release version name in add Release popup
    Then Select valid Project name "Automation Testing" in add Release popup
    And Select valid task option "AT-04 - Testing summary @123" in add Release popup
    Then Select valid start date "1" in add Release popup
    And Select valid release date "15" in add Release popup
    Then Select valid release start time "10" and "30" and "A" in add Release popup
    And Select valid release end time "12" and "30" and "P" in add Release popup
    Then Enter valid description "Test Description" in add Release popup
    And Click save button in add Release popup
    Then Check success message is displayed or not in Release
    Then Close Release page

  @TC_09
  Scenario: Release:Edit Release:Update Check
    Given Click Release screen button in the menu bar
    When Enter valid release version name "V2.1" in Release screen
    And Click edit button in release screen
    Then Modify the details in edit release popup
    And Click update button in edit release popup
    Then Check success message is displayed or not in Release
    Then Close Release page

  @TC_10
  Scenario: Release:Edit Release:Update Check
    Given Click user logo button in dashboard
    And Click logout button in profile tab
    Then Enter valid release manager mail id "releasemanagersankara@yahoo.com" in email tab
    And Enter valid password "Thirumaran@123" in login page
    When Click the login button for release manager
    Then Click Release button in the menu bar
    And Click Release screen button in the menu bar
    Then Enter valid release version name "V0.0.1" in Release screen
    And Click the release version name in release screen
    Then Check page landed to deployment request page or not in release screen
    Then Close Release page
    
    @TC_11
  Scenario: Release:Edit Release:Update Check
    Given Click user logo button in dashboard
    And Click logout button in profile tab
    Then Enter valid project lead mail id "projectleadsankara@yahoo.com" in email tab
    And Enter valid password "Thirumaran@123" in login page
    When Click the login button for release manager
    Then Click Release button in the menu bar
    And Click Release screen button in the menu bar
    Then Enter valid release version name "V0.0.1" in Release screen
    And Click the release version name in release screen
    Then Check page landed to release checklist page or not in release screen
    Then Close Release page
    
    @TC_12
  Scenario: Release:Edit Release:Update Check
    Given Click user logo button in dashboard
    And Click logout button in profile tab
    Then Enter valid project lead mail id "projectleadsankara@yahoo.com" in email tab
    And Enter valid password "Thirumaran@123" in login page
    When Click the login button for release manager
    Then Click Release button in the menu bar
    And Click Release screen button in the menu bar
    Then Enter valid release version name "V0.0.1" in Release screen
    And Click the release version name in release screen
    Then Click submit button in release checklist screen
    And Check error message is displayed or not in release checklist screen
    Then Close Release page
    
    @TC_13
  Scenario: Release:Edit Release:Update Check
    Given Click user logo button in dashboard
    And Click logout button in profile tab
    Then Enter valid project lead mail id "projectleadsankara@yahoo.com" in email tab
    And Enter valid password "Thirumaran@123" in login page
    When Click the login button for release manager
    Then Click Release button in the menu bar
    And Click Release screen button in the menu bar
    Then Enter valid release version name "V0.0.1" in Release screen
    And Click the release version name in release screen
    Then Select all checkbox in release checklist screen
    Then Click submit button in release checklist screen
    And Check error message is displayed or not in release checklist screen
    Then Close Release page
    
    @TC_14
  Scenario: Release:Edit Release:Update Check
    Given Click user logo button in dashboard
    And Click logout button in profile tab
    Then Enter valid project lead mail id "projectleadsankara@yahoo.com" in email tab
    And Enter valid password "Thirumaran@123" in login page
    When Click the login button for release manager
    Then Click Release button in the menu bar
    And Click Release screen button in the menu bar
    Then Enter valid release version name "V0.0.1" in Release screen
    And Click the release version name in release screen
    Then Select all checkbox in release checklist screen
    And Enter valid source path "sourcePath/AutomationTesting" in release checklist screen
    Then Enter valid db path "dbPath/AutomationTesting" in release checklist screen
    And Enter valid notes "Automation testing release notes" in release checklist screen
    Then Click submit button in release checklist screen
    And Check success message is displayed or not in release checklist screen
    Then Close Release page
