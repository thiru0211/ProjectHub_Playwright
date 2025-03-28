Feature: ADMIN

  Background: Admin
    Given To Check Admin user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When To Check Admin Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@123"
    And Click the Login button To Check Admin
    Then Click Admin button in the menu bar

  @TC_01
  Scenario: Users:Search Check
    Given Click Users button in the menu bar
    When Enter valid username "Developer Sankara" in the searchbox in user screen
    And Check entered username "Developer Sankara" is displayed or not in user screen
    Then Enter valid email id "developersankara@gmail.com" in the searchbox in user screen
    And Check entered email id "developersankara@gmail.com" is displayed or not in user screen
    And Enter valid designation "Client Admin" in the searchbox in user screen
    Then Check entered designation "Client Admin" is displayed or not in user screen
    Then Close Admin page

  @TC_02
  Scenario: Users:Filter Check
    Given Click Users button in the menu bar
    When Select "All" 1st option in the filter dropdown
    And Select "Active" 2nd option in the filter dropdown
    Then Check "Active" 2nd option is displayed or not in user screen
    And Select "Inactive" 3rd option in the filter dropdown
    Then Check "Inactive" 3rd option is displayed or not in user screen
    Then Close Admin page

  @TC_03
  Scenario: Add New:Back button Check
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    And Click Back button in add user screen
    Then Check page navigates to previous page or not in user screen
    Then Close Admin page

  @TC_04
  Scenario: Add New:Mandatory Check
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    And Click save button in add user screen
    Then Check mandatory message is displayed in mandatory tabs or not user screen
    # And Check mandatory red border is displayed in mandatory tabs or not user screen
    Then Close Admin page

  @TC_05
  Scenario: Add New:Mandatory Clear Check
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    And Click save button in add user screen
    Then Click clear button in add user screen
    Then Check mandatory message is displayed in mandatory tabs or not user screen
    # And Check mandatory red border is displayed in mandatory tabs or not user screen
    Then Close Admin page

  @TC_06
  Scenario: Add New:First Name Invalid Check
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    And Enter special characters "!@#$%" in first name field in add user screen
    #Then Check first name tab is empty or not in add user screen
    Then Close Admin page

  @TC_07
  Scenario: Add New:First Name Invalid Check
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    And Enter numerical characters "12345" in first name field in add user screen
    #Then Check first name tab is empty or not in add user screen
    Then Close Admin page

  @TC_08
  Scenario: Add New:First Name Valid Check
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    And Enter alpha characters "Thirumaran" in first name field in add user screen
    Then Check entered characters "Thirumaran" in first name tab is displayed or not in add user screen
    Then Close Admin page

  @TC_09
  Scenario: Add New:Last Name Invalid Check
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    And Enter special characters "!@#$%" in last name field in add user screen
    #Then Check last name tab is empty or not in add user screen
    Then Close Admin page

  @TC_10
  Scenario: Add New:Last Name Invalid Check
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    And Enter numerical characters "12345" in last name field in add user screen
    #Then Check last name tab is empty or not in add user screen
    Then Close Admin page

  @TC_11
  Scenario: Add New:Last Name Invalid Check
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    And Enter alpha characters "Thirumaran" in last name field in add user screen
    Then Check entered characters "Thirumaran" in last name tab is displayed or not in add user screen
    Then Close Admin page

  @TC_12
  Scenario: Add New:Email Invalid Check
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    And Enter email address "thirumaran@yopmail" in email address field in add user screen
    Then Click save button in add user screen
    And Check error message is displayed or not in email address tab in add user screen
    Then Close Admin page

  @TC_13
  Scenario: Add New:Email Invalid Check
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    And Enter email address "thirumaranyopmail.com" in email address field in add user screen
    Then Click save button in add user screen
    And Check error message is displayed or not in email address tab in add user screen
    Then Close Admin page

  @TC_14
  Scenario: Add New:Phone Number Invalid Check
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    And Enter special characters "!@#$%" in Phone Number field in add user screen
    #   Then Check Phone Number tab is empty or not in add user screen
    Then Close Admin page

  @TC_15
  Scenario: Add New:Phone Number Invalid Check
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    And Enter alpha characters "Thiru" in Phone Number field in add user screen
    #   Then Check Phone Number tab is empty or not in add user screen
    Then Close Admin page

  @TC_16
  Scenario: Add New:Phone Number Invalid Check
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    And Enter alpha characters "9876543210" in Phone Number field in add user screen
    Then Check entered characters "9876543210" in Phone Number tab is displayed or not in add user screen
    Then Close Admin page

  @TC_17
  Scenario: Add New:Project Mapping
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    Then Select valid project name "Accounting" in add user screen
    # And Check select name "Accounting" is displayed or not in add user screen
    Then Close Admin page

  @TC_18
  Scenario: Add New:Clear Check
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    And Enter valid details in first name tab in add user screen
    Then Enter valid details in last name tab in add user screen
    And Enter valid email id in add user screen
    Then Enter valid phone number in add user screen
    And Select valid report to option in add user screen
    Then Select valid designation in add user screen
    And Select valid timezone in add user screen
    Then Click Yes radio button in 2FA in add user screen
    And Click Email radio button in send 2FA in add user screen
    Then Select valid project name "Accounting" in add user screen
    And Click clear button in user screen
    Then Close Admin page

  @TC_19
  Scenario: Add New:Clear Check
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    And Enter valid details in first name tab in add user screen
    Then Enter valid details in last name tab in add user screen
    And Enter valid email id in add user screen
    Then Enter valid phone number in add user screen
    And Select valid report to option in add user screen
    Then Select valid designation in add user screen
    And Select valid timezone in add user screen
    Then Click Yes radio button in 2FA in add user screen
    And Click SMS radio button in send 2FA in add user screen
    Then Select valid project name "Accounting" in add user screen
    And Click clear button in user screen
    Then Close Admin page

  @TC_20
  Scenario: Add New:Clear Check
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    And Enter valid details in first name tab in add user screen
    Then Enter valid details in last name tab in add user screen
    And Enter valid email id in add user screen
    Then Enter valid phone number in add user screen
    And Select valid report to option in add user screen
    Then Select valid designation in add user screen
    And Select valid timezone in add user screen
    Then Click No radio button in 2FA in add user screen
    Then Select valid project name "Accounting" in add user screen
    And Click clear button in user screen
    Then Close Admin page

  @TC_21
  Scenario: Add New:Save Check
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    And Enter valid details in first name tab in add user screen
    Then Enter valid details in last name tab in add user screen
    And Enter valid email id in add user screen
    Then Enter valid phone number in add user screen
    And Select valid report to option in add user screen
    Then Select valid designation in add user screen
    And Select valid timezone in add user screen
    Then Click Yes radio button in 2FA in add user screen
    And Click Email radio button in send 2FA in add user screen
    Then Select valid project name "Accounting" in add user screen
    And Click save button in add user screen
    Then Check success message is displayed or not in add user screen
    Then Close Admin page

  @TC_22
  Scenario: Add New:Save Check
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    And Enter valid details in first name tab in add user screen
    Then Enter valid details in last name tab in add user screen
    And Enter valid email id in add user screen
    Then Enter valid phone number in add user screen
    And Select valid report to option in add user screen
    Then Select valid designation in add user screen
    And Select valid timezone in add user screen
    Then Click Yes radio button in 2FA in add user screen
    And Click SMS radio button in send 2FA in add user screen
    Then Select valid project name "Accounting" in add user screen
    And Click save button in add user screen
    Then Check success message is displayed or not in add user screen
    Then Close Admin page

  @TC_23
  Scenario: Add New:Save Check
    Given Click Users button in the menu bar
    When Click Add New button in user screen
    And Enter valid details in first name tab in add user screen
    Then Enter valid details in last name tab in add user screen
    And Enter valid email id in add user screen
    Then Enter valid phone number in add user screen
    And Select valid report to option in add user screen
    Then Select valid designation in add user screen
    And Select valid timezone in add user screen
    Then Click No radio button in 2FA in add user screen
    Then Select valid project name "Accounting" in add user screen
    And Click save button in add user screen
    Then Check success message is displayed or not in add user screen
    Then Close Admin page

  @TC_24
  Scenario: Edit:Back button Check
    Given Click Users button in the menu bar
    When Enter valid username "New User" in the searchbox in user screen
    And Click edit button in user screen
    And Click Back button in add user screen
    Then Check page navigates to previous page or not in user screen
    Then Close Admin page

  @TC_25
  Scenario: Edit:Clear button Check
    Given Click Users button in the menu bar
    When Enter valid username "New User" in the searchbox in user screen
    And Click edit button in user screen
    And Click clear button in add user screen
    Then Close Admin page

  @TC_26
  Scenario: Edit:Update Check
    Given Click Users button in the menu bar
    When Enter valid username "New User" in the searchbox in user screen
    And Click edit button in user screen
    Then Modify valid details in edit user screen
    And Click update button in edit user screen
    #Then Check success message is displayed or not in edit user screen
    Then Close Admin page

  @TC_27
  Scenario: Create Team:Close button check
    Given Click Team button in the menu bar
    When Click create team button in Team
    Then Click close button in Create Team
    Then Close Admin page

  @TC_28
  Scenario: Create Team:Mandatory check
    Given Click Team button in the menu bar
    When Click create team button in Team
    Then Click save button in Create Team
    And Check mandatory message is displayed or not in Create Team
    Then Close Admin page

  @TC_29
  Scenario: Create Team:Clear button check
    Given Click Team button in the menu bar
    When Click create team button in Team
    Then Enter valid team name "PB-Testing Team" in Create Team
    And Select valid users "Praveen Kumar" in Create Team
    #Then Select valid status "Active" in Create Team
    And Click clear button in Create Team
    And Check details cleared or not in Create Team
    Then Close Admin page

  @TC_30
  Scenario: Create Team:Save button check
    Given Click Team button in the menu bar
    When Click create team button in Team
    Then Enter valid team name "PB-Testing Team" in Create Team
    And Select valid users "Praveen Kumar" in Create Team
    #Then Select valid status "Active" in Create Team
    And Click save button in Create Team
    And Check success message is displayed or not in Create Team
    Then Close Admin page

  @TC_31
  Scenario: Edit:Close button check
    Given Click Team button in the menu bar
    When Click edit button in Team
    And Click close button in Create Team
    Then Close Admin page

  @TC_32
  Scenario: Edit:Clear button check
    Given Click Team button in the menu bar
    When Click edit button in Team
    Then Click clear button in edit Team
    And Check details are cleared or not in edit Team
    Then Close Admin page

  @TC_33
  Scenario: Edit:Update button check
    Given Click Team button in the menu bar
    When Click edit button in Team
    Then Modify valid details in edit Team
    And Click update button in edit Team
    Then Check success message is displayed or not in Create Team
    Then Close Admin page

  @TC_34
  Scenario: Delete:Cancel Check
    Given Click Team button in the menu bar
    When Click delete button in Team
    When Click cancel button in Team
    Then Close Admin page

  @TC_35
  Scenario: Delete:Delete Check
    Given Click Team button in the menu bar
    When Click delete button in Team
    Then Click delete button in delete popup in Team
    And Check success message is displayed or not in Team
    Then Close Admin page

  @TC_36
  Scenario: Screen Rights:Invalid Check
    Given Click Screen Rights button in the menu bar
    When Unselect the all checkbox in screen rights page
    And Click save button in screen rights page
    Then Check the alert message in screen rights page
    Then Close Admin page

  @TC_37
  Scenario: Screen Rights:Valid Check
    Given Click Screen Rights button in the menu bar
    When Unselect the all checkbox in screen rights page
    And Click one checkbox in screen rights page
    Then Click save button in screen rights page
    And Check the success message in screen rights page
    Then Close Admin page

  @TC_38
  Scenario: Screen Rights:Valid Check
    Given Click Screen Rights button in the menu bar
    When Select all checkbox in screen rights page
    And Click save button in screen rights page
    Then Check the success message in screen rights page
    And Check all checkbox is selected or not in screen rights page
    Then Close Admin page

  @TC_39
  Scenario: Screen Rights:Valid Check
    Given Click Screen Rights button in the menu bar
    When Unselect the all checkbox in screen rights page
    And Click one checkbox in screen rights page
    Then Click save button in screen rights page
    And Check the success message in screen rights page
    Then Close Admin page

  @TC_40
  Scenario: Screen Rights:Valid Check
    Given Click Screen Rights button in the menu bar
    When Unselect the all checkbox in screen rights page
    And Click one checkbox in screen rights page
    Then Click save button in screen rights page
    And Check the success message in screen rights page
    Then Close Admin page
