Feature: TASK MANAGEMENT

  Background: Task Management
    Given To Check Task Management user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When To Check Task Management Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@123"
    And Click the Login button To Check Task Management
    Then Click Task Management button in the menu bar

  @TC_01
  Scenario: Project:Search Check
    Given Click Project button in the menu bar
    When Enter valid Project Name "Automation Testing" in the searchbox in Project screen
    And Check entered Project name "Automation Testing" is displayed or not in Project screen
    Then Close Task Management page

  @TC_02
  Scenario: Project:Search Check
    Given Click Project button in the menu bar
    When Enter valid Lead Name "Vignesh Murugan" in the searchbox in Project screen
    And Check entered Lead name "Vignesh Murugan" is displayed or not in Project screen
    Then Close Task Management page

  @TC_03
  Scenario: Add New:Back button Check
    Given Click Project button in the menu bar
    When Click Add New button in Project screen
    And Click Back button in add Project screen
    Then Check landing page in Project screen
    Then Close Task Management page

  @TC_04
  Scenario: Add New:Mandatory Check
    Given Click Project button in the menu bar
    When Click Add New button in Project screen
    And Click save button in add Project screen
    Then Check mandatory message is displayed or not in add Project screen
    Then Close Task Management page

  @TC_05
  Scenario: Add New:Mandatory Clear Check
    Given Click Project button in the menu bar
    When Click Add New button in Project screen
    And Click save button in add Project screen
    Then Check mandatory message is displayed or not in add Project screen
    And Click clear button in add Project screen
    Then Check mandatory message is cleared or not in add Project screen
    Then Close Task Management page

  @TC_06
  Scenario: Add New:Clear Check
    Given Click Project button in the menu bar
    When Click Add New button in Project screen
    And Enter valid Project Name in add Project screen
    Then Enter valid Project Code in add Project screen
    And Click project radio button in add Project screen
    #Then Select Active status in add Project screen
    And Click Timeline button in add Project screen
    Then Click clear button in Project screen
    Then Check entered data is cleared or not in add Project screen
    Then Close Task Management page

  @TC_07
  Scenario: Add New:Save Check
    Given Click Project button in the menu bar
    When Click Add New button in Project screen
    And Enter valid Project Name in add Project screen
    Then Enter valid Project Code in add Project screen
    And Click project radio button in add Project screen
    # Then Select Active status in add Project screen
    And Click Kanban Board button in add Project screen
    Then Click save button in Project screen
    Then Check success message is displayed or not in add Project screen
    Then Close Task Management page

  @TC_08
  Scenario: Add New:Save Check
    Given Click Project button in the menu bar
    When Click Add New button in Project screen
    And Enter valid Project Name in add Project screen
    Then Enter valid Project Code in add Project screen
    And Click project radio button in add Project screen
    # Then Select Active status in add Project screen
    And Click Timeline button in add Project screen
    Then Click save button in Project screen
    Then Check success message is displayed or not in add Project screen
    Then Close Task Management page

  @TC_09
  Scenario: Add New:Save Check
    Given Click Project button in the menu bar
    When Click Add New button in Project screen
    And Enter valid Project Name in add Project screen
    Then Enter valid Project Code in add Project screen
    And Click support radio button in add Project screen
    #Then Select Active status in add Project screen
    And Click Kanban Board button in add Project screen
    Then Enter valid domain name "gmail.com" in add Project screen
    # And Select valid mail server "gmail.com" in add Project screen
    Then Enter valid host name "Test server" in add Project screen
    And Enter valid support email "test@gmail.com" in add Project screen
    Then Enter valid password "Thirumaran@12345" in add Project screen
    And Enter valid port "8081" in add Project screen
    Then Click save button in Project screen
    Then Check success message is displayed or not in add Project screen
    Then Close Task Management page

  @TC_10
  Scenario: Add New:Save Check
    Given Click Project button in the menu bar
    When Click Add New button in Project screen
    And Enter valid Project Name in add Project screen
    Then Enter valid Project Code in add Project screen
    And Click support radio button in add Project screen
    #Then Select Active status in add Project screen
    And Click Timeline button in add Project screen
    Then Enter valid domain name "gmail.com" in add Project screen
    # And Select valid mail server "gmail.com" in add Project screen
    Then Enter valid host name "Test server" in add Project screen
    And Enter valid support email "test@gmail.com" in add Project screen
    Then Enter valid password "Thirumaran@12345" in add Project screen
    And Enter valid port "8081" in add Project screen
    Then Click save button in Project screen
    Then Check success message is displayed or not in add Project screen
    Then Close Task Management page

  @TC_11
  Scenario: Edit:Back button Check
    Given Click Project button in the menu bar
    When Enter valid Project Name "Automation Testing" in the searchbox in Project screen
    And Click edit button in project screen
    Then Click back button in project screen
    And Check landing page in Project screen
    Then Close Task Management page

  @TC_12
  Scenario: Edit:Clear button Check
    Given Click Project button in the menu bar
    When Enter valid Project Name "Automation Testing" in the searchbox in Project screen
    And Click edit button in project screen
    Then Click clear button in edit project screen
    And Check previous details is cleared or not in edit project screen
    Then Close Task Management page

  @TC_13
  Scenario: Edit:Reset button Check
    Given Click Project button in the menu bar
    When Enter valid Project Name "Automation Testing" in the searchbox in Project screen
    And Click edit button in project screen
    Then Modify valid details in edit project screen
    And Click reset button in edit project screen
    And Check previous details is displayed or not in edit project screen
    Then Close Task Management page

  @TC_14
  Scenario: Edit:Update button Check
    Given Click Project button in the menu bar
    When Enter valid Project Name "Automation Testing" in the searchbox in Project screen
    And Click edit button in project screen
    Then Modify valid details in edit project screen
    And Click upade button in edit project screen
    And Check success message is displayed or not in edit project screen
    Then Close Task Management page

  @TC_15
  Scenario: Landing Check:Kanban Board Project Check
    Given Click Project button in the menu bar
    When Enter valid Kanban Board Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Check page landed to kanban board screen or not
    Then Close Task Management page

  @TC_16
  Scenario: Landing Check:Timeline Project Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Bike Rental" in the searchbox in Project screen
    And Click project name in project screen
    Then Check page landed to timeline screen or not
    Then Close Task Management page

  @TC_17
  Scenario: Overview:Project Description
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    And Click overview button in project screen
    Then Enter valid details "Test Project" in description box in project screen
    And Check tab is empty or not in description box
    Then Close Task Management page

  @TC_18
  Scenario: Project Roles:Create Project Roles Close button check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    And Click overview button in project screen
    Then Click project roles button in overview screen
    And Click close button in add team
    Then Close Task Management page

  @TC_19
  Scenario: Project Roles:Create Team Valid check
    Given Click Project button in the menu bar
    When Click Add New button in Project screen
    And Enter valid Project Name in add Project screen
    Then Enter valid Project Code in add Project screen
    And Click project radio button in add Project screen
    And Click Kanban Board button in add Project screen
    Then Click save button in Project screen
    Then Check success message is displayed or not in add Project screen
    And Click overview button in project screen
    Then Click create team button in overview screen
    And Select valid default email "0211thiru@gmail.com" in add team
    Then Select valid users "Eliya Rani" in add team
    And Select valid lead name "Vignesh Murugan" in add team
    Then Click save button in add team
    And Check success message is displayed or not in add team
    Then Close Task Management page

  #@TC_20
  #Scenario: Project Roles:Project Attachements Invalid check
  #Given Click Project button in the menu bar
  #When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
  #And Click project name in project screen
  #And Click overview button in project screen
  #Then Click upload button in project attachements
  #And Upload invalid file type in project attachements
  #Then Check error message is displayed or not in add team
  #Then Close Task Management page
  #@TC_21
  #Scenario: Project Roles:Project Attachements Valid check
  #Given Click Project button in the menu bar
  #When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
  #And Click project name in project screen
  #And Click overview button in project screen
  #Then Click upload button in project attachements
  #And Upload single valid file type in project attachements
  #Then Check single file is displayed or not in project attachement tab
  #Then Close Task Management page
  #@TC_22
  #Scenario: Project Roles:Project Attachements Valid check
  #Given Click Project button in the menu bar
  #When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
  #And Click project name in project screen
  #And Click overview button in project screen
  #Then Click upload button in project attachements
  #And Upload multiple valid file type in project attachements
  #Then Check multiple file is displayed or not in project attachement tab
  #Then Close Task Management page
  
  @TC_23
  Scenario: Project Roles:Goal Close button check
    Given Click Project button in the menu bar
    When Click Add New button in Project screen
    And Enter valid Project Name in add Project screen
    Then Enter valid Project Code in add Project screen
    And Click project radio button in add Project screen
    And Click Kanban Board button in add Project screen
    Then Click save button in Project screen
    Then Check success message is displayed or not in add Project screen
    And Click overview button in project screen
    Then Click add goal button in overview screen
    And Click close button in add goal page
    Then Close Task Management page

  @TC_24
  Scenario: Project Roles:Goal Mandatory check
    Given Click Project button in the menu bar
    When Click Add New button in Project screen
    And Enter valid Project Name in add Project screen
    Then Enter valid Project Code in add Project screen
    And Click project radio button in add Project screen
    And Click Kanban Board button in add Project screen
    Then Click save button in Project screen
    Then Check success message is displayed or not in add Project screen
    And Click overview button in project screen
    Then Click add goal button in overview screen
    And Click add button in add goal page
    Then Click save button in add goal page
    And Check mandatory message is displayed or not in add goal page
    Then Close Task Management page

  @TC_25
  Scenario: Project Roles:Goal Delete check
    Given Click Project button in the menu bar
    When Click Add New button in Project screen
    And Enter valid Project Name in add Project screen
    Then Enter valid Project Code in add Project screen
    And Click project radio button in add Project screen
    And Click Kanban Board button in add Project screen
    Then Click save button in Project screen
    Then Check success message is displayed or not in add Project screen
    And Click overview button in project screen
    Then Click add goal button in overview screen
    And Click add button in add goal page
    Then Select valid start target in add goal page
    And Select valid end target in add goal page
    #Then Click add button in add goal page
    And Select valid from date in first row
    Then Select valid to date in first row
    And Click delete button in first row
    And Check success message is displayed or not in add goal page
    Then Close Task Management page

  @TC_26
  Scenario: Project Roles:Goal Save check
    Given Click Project button in the menu bar
    When Click Add New button in Project screen
    And Enter valid Project Name in add Project screen
    Then Enter valid Project Code in add Project screen
    And Click project radio button in add Project screen
    And Click Kanban Board button in add Project screen
    Then Click save button in Project screen
    Then Check success message is displayed or not in add Project screen
    And Click overview button in project screen
    Then Click add goal button in overview screen
    And Click add button in add goal page
    Then Select valid start target in add goal page
    And Select valid end target in add goal page
    #Then Click add button in add goal page
    And Select valid from date in first row
    Then Select valid to date in first row
    Then Enter valid description "Development" in first row
    And Click save button in add goal page
    And Check success message is displayed or not in add goal page
    Then Close Task Management page

  @TC_27
  Scenario: Project Roles:Goal Save check
    Given Click Project button in the menu bar
    When Click Add New button in Project screen
    And Enter valid Project Name in add Project screen
    Then Enter valid Project Code in add Project screen
    And Click project radio button in add Project screen
    And Click Kanban Board button in add Project screen
    Then Click save button in Project screen
    Then Click add goal button in overview screen
    Then Select valid start target in add goal page
    And Select valid end target in add goal page
    Then Click add button in add goal page
    And Select valid from date in first row
    Then Select valid to date in first row
    Then Enter valid description "Development" in first row
    Then Click add button in add goal page
    And Select valid from date in second row
    Then Select valid to date in second row
    And Enter valid description "Testing" in second row
    And Click save button in add goal page
    And Check success message is displayed or not in add goal page
    Then Close Task Management page

  @TC_28
  Scenario: Overview:Raised By Close Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    And Click overview button in project screen
    Then Click raised by button in overview screen
    And Click close button in raised by popup in overview screen
    Then Close Task Management page

  @TC_29
  Scenario: Overview:Raised By username Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    And Click overview button in project screen
    Then Click raised by button in overview screen
    And Enter valid username "Venessa Beier" in searchbox in raised by popup
    Then Check entered username "Venessa Beier" is displayed or not in raised by popup
    Then Close Task Management page

  @TC_30
  Scenario: Overview:Raised By Clear Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    And Click overview button in project screen
    Then Click raised by button in overview screen
    And Click add new button in raised by popup
    Then Enter valid user name in raised by popup
    And Enter valid user email id in raised by popup
    Then Click clear button in raised by popup
    And Check username field is empty or not in raised by popup
    Then Check user email id field is empty or not in raised by popup
    Then Close Task Management page

  @TC_31
  Scenario: Overview:Raised By Save Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    And Click overview button in project screen
    Then Click raised by button in overview screen
    And Click add new button in raised by popup
    Then Enter valid user name in raised by popup
    And Enter valid user email id in raised by popup
    Then Click save button in raised by popup
    And Check success message is displayed or not in raised by popup
    Then Close Task Management page

  @TC_32
  Scenario: Overview:Raised By Clear Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    And Click overview button in project screen
    Then Click raised by button in overview screen
    And Enter valid username "Thirumaran" in searchbox in raised by popup
    And Click edit button in raised by popup
    Then Click clear button in raised by popup
    And Check username field is empty or not in raised by popup
    Then Check user email id field is empty or not in raised by popup
    Then Close Task Management page

  @TC_33
  Scenario: Overview:Raised By Update Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    And Click overview button in project screen
    Then Click raised by button in overview screen
    And Enter valid username "Thirumaran" in searchbox in raised by popup
    And Click edit button in raised by popup
    Then Modify valid details in raised by popup
    And Click update button in raised by popup
    And Check success message is displayed or not in raised by popup
    Then Close Task Management page

  @TC_34
  Scenario: Overview:Raised By Delete Cancel Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    And Click overview button in project screen
    Then Click raised by button in overview screen
    And Enter valid username "thirumaran@sankarasoftware.com" in searchbox in raised by popup
    Then Click delete button in raised by popup
    Then Click cancel button in confirmation popup
    Then Close Task Management page

  @TC_35
  Scenario: Overview:Raised By Delete Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    And Click overview button in project screen
    Then Click raised by button in overview screen
    And Enter valid username "thirumaran@sankarasoftware.com" in searchbox in raised by popup
    Then Click delete button in raised by popup
    Then Click delete button in confirmation popup
    And Check success message is displayed or not in raised by popup
    Then Close Task Management page

  @TC_36
  Scenario: Overview:Raised By Save Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    And Click overview button in project screen
    Then Click raised by button in overview screen
    And Click add new button in raised by popup
    Then Enter valid user name "Thirumaran" in raised by popup
    And Enter valid user email id "thirumaran@sankarasoftware.com" in raised by popup
    Then Click save button in raised by popup
    And Check success message is displayed or not in raised by popup
    Then Close Task Management page

  @TC_37
  Scenario: Kanban Board:Project Selection
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Select valid project "Nextestify" from the dropdown in kanban board screen
    And Check selected project name "Nextestify" is displayed or not in kanban board screen
    Then Close Task Management page

  @TC_38
  Scenario: Kanban Board:Issue Type Filter Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Select issue type "Epic" from the dropdown in kanban board screen
    Then Close Task Management page

  @TC_39
  Scenario: Kanban Board:Search Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Enter valid id "AT-01" in search box in kanban board screen
    And Check entered id "AT-01" is displayed or not in kanban board screen
    Then Close Task Management page

  @TC_40
  Scenario: Kanban Board:Create Task:Close button check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Click create button in kanban board
    And Click close button in create issue popup
    Then Close Task Management page

  @TC_41
  Scenario: Kanban Board:Create Task:Mandatory check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Click create button in kanban board
    And Click save button in create issue popup
    Then Check mandatory message is displayed or not in create issue popup
    Then Close Task Management page

  @TC_42
  Scenario: Kanban Board:Create Task:Project Option check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Click create button in kanban board
    And Check selected project name "Automation Testing" is displayed in project dropdown or not in create issue popup
    Then Close Task Management page

  @TC_43
  Scenario: Kanban Board:Create Task:Issue Type Option check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Click create button in kanban board
    And Select valid issue type "Epic" in create issue popup
    And Check selected issue type "Epic" is displayed in issue type dropdown or not in create issue popup
    Then Close Task Management page

  @TC_44
  Scenario: Kanban Board:Create Task:Label Option check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Click create button in kanban board
    And Select valid label "Testing" in create issue popup
    And Check selected label "Testing" is displayed in label dropdown or not in create issue popup
    Then Close Task Management page

  @TC_45
  Scenario: Kanban Board:Create Task:Summary check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Click create button in kanban board
    And Enter valid summary details "Testing summary @123" in create issue popup
    And Check entered details "Testing summary @123" in summary tab is didplayed or not in create issue popup
    Then Close Task Management page

  @TC_46
  Scenario: Kanban Board:Create Task:Description check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Click create button in kanban board
    And Enter valid description details "Testing description @123" in create issue popup
    And Check entered details "Testing description @123" in description tab is didplayed or not in create issue popup
    Then Close Task Management page

  @TC_47
  Scenario: Kanban Board:Create Task:Assignee Option check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Click create button in kanban board
    And Select valid Assignee "Thirumaran R" in create issue popup
    And Check selected Assignee "Thirumaran R" is displayed in Assignee dropdown or not in create issue popup
    Then Close Task Management page

  @TC_48
  Scenario: Kanban Board:Create Task:Reporting To Option check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Click create button in kanban board
    And Select valid Reporting To "Eliya Rani" in create issue popup
    #And Check selected Reporting To "Eliya Rani" is displayed in Reporting To dropdown or not in create issue popup
    Then Close Task Management page

  @TC_49
  Scenario: Kanban Board:Create Task:Priority Option check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Click create button in kanban board
    And Select valid Priority "Low" in create issue popup
    # And Check selected Priority "Low" is displayed in Priority dropdown or not in create issue popup
    Then Close Task Management page

  #@TC_50
  #Scenario: Kanban Board:Create Task:Attachment Invalid Check
  #Given Click Project button in the menu bar
  #When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
  #And Click project name in project screen
  #Then Click create button in kanban board
  #And Upload invalid file type in create issue popup
  #And Check error message is displayed or not in create issue popup
  #Then Close Task Management page
  #
  #@TC_51
  #Scenario: Kanban Board:Create Task:Attachment Valid Check
  #Given Click Project button in the menu bar
  #When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
  #And Click project name in project screen
  #Then Click create button in kanban board
  #And Upload valid file type in create issue popup
  #Then Close Task Management page
  
  @TC_52
  Scenario: Kanban Board:Create Task:Clear Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Click create button in kanban board
    Then Select valid issue type "Epic" in create issue popup
    And Select valid label "Testing" in create issue popup
    And Enter valid summary details "Testing summary @123" in create issue popup
    Then Enter valid details "Test Project" in description box in project screen
    And Select valid Assignee "Thirumaran R" in create issue popup
    Then Select valid Reporting To "Eliya Rani" in create issue popup
    And Select valid Priority "Low" in create issue popup
    #Then Upload valid file type in create issue popup
    And Click clear button in create issue popup
    Then Close Task Management page

  @TC_53
  Scenario: Kanban Board:Create Task:Save Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Click create button in kanban board
    Then Select valid issue type "Epic" in create issue popup
    And Select valid label "Testing" in create issue popup
    And Enter valid summary details "Testing summary @123" in create issue popup
    Then Enter valid details "Test Project" in description box in project screen
    And Select valid Assignee "Thirumaran R" in create issue popup
    Then Select valid Reporting To "Eliya Rani" in create issue popup
    And Select valid Priority "Low" in create issue popup
    #Then Upload valid file type in create issue popup
    And Click save button in create issue popup
    Then Check success message is displayed or not in create issue popup
    Then Close Task Management page

  @TC_54
  Scenario: Kanban Board:Create Task:Save Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Click create button in kanban board
    Then Select valid issue type "Story" in create issue popup
    And Select valid label "Testing" in create issue popup
    And Enter valid summary details "Testing summary @123" in create issue popup
    Then Enter valid details "Test Project" in description box in project screen
    And Select valid Assignee "Thirumaran R" in create issue popup
    Then Select valid Reporting To "Eliya Rani" in create issue popup
    And Select valid Priority "Low" in create issue popup
    #Then Upload valid file type in create issue popup
    And Click save button in create issue popup
    Then Check success message is displayed or not in create issue popup
    Then Close Task Management page

  @TC_55
  Scenario: Kanban Board:Create Task:Save Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Click create button in kanban board
    Then Select valid issue type "Task" in create issue popup
    And Select valid label "Testing" in create issue popup
    And Enter valid summary details "Testing summary @123" in create issue popup
    Then Enter valid details "Test Project" in description box in project screen
    And Select valid Assignee "Thirumaran R" in create issue popup
    Then Select valid Reporting To "Eliya Rani" in create issue popup
    And Select valid Priority "Low" in create issue popup
    #Then Upload valid file type in create issue popup
    And Click save button in create issue popup
    Then Check success message is displayed or not in create issue popup
    Then Close Task Management page

  @TC_56
  Scenario: Kanban Board:Edit Task:EPIC Modify
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Select issue type "Epic" from the dropdown in kanban board screen
    Then Enter valid id "AT-02" in search box in kanban board screen
    And Click task name "AT-02" in kanban board screen
    Then Modify the details in edit issue screen
    And Click close button in edit issue screen
    And Click task name "AT-02" in kanban board screen
    Then Check details are updated or not in edit issue screen
    Then Close Task Management page

  @TC_57
  Scenario: Kanban Board:Edit Task:STORY Modify
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Select issue type "Story" from the dropdown in kanban board screen
    Then Enter valid id "AT-03" in search box in kanban board screen
    And Click task name "AT-03" in kanban board screen
    Then Modify the details in edit issue screen
    And Click close button in edit issue screen
    And Click task name "AT-03" in kanban board screen
    Then Check details are updated or not in edit issue screen
    Then Close Task Management page

  @TC_58
  Scenario: Kanban Board:Edit Task:TASK Modify
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Select issue type "Task" from the dropdown in kanban board screen
    Then Enter valid id "AT-01" in search box in kanban board screen
    And Click task name "AT-01" in kanban board screen
    Then Modify the details in edit issue screen
    And Click close button in edit issue screen
    And Click task name "AT-01" in kanban board screen
    Then Check details are updated or not in edit issue screen
    Then Close Task Management page

  @TC_59
  Scenario: Kanban Board:Edit Task:Estimated Time Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Select issue type "Task" from the dropdown in kanban board screen
    Then Enter valid id "AT-01" in search box in kanban board screen
    And Click task name "AT-01" in kanban board screen
    Then Enter valid estimated time "5h" in edit issue screen
    And Click close button in edit issue screen
    And Click task name "AT-01" in kanban board screen
    Then Check estimated time "5h" is displayed or not in edit issue screen
    Then Close Task Management page

  @TC_60
  Scenario: Kanban Board:Edit Task:Time Tracking Close Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Select issue type "Task" from the dropdown in kanban board screen
    Then Enter valid id "AT-01" in search box in kanban board screen
    And Click task name "AT-01" in kanban board screen
    Then Click time tracking button in edit issue screen
    And Click close button in time tracking screen
    Then Close Task Management page

  @TC_61
  Scenario: Kanban Board:Edit Task:Time Tracking Invalid Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Select issue type "Task" from the dropdown in kanban board screen
    Then Enter valid id "AT-01" in search box in kanban board screen
    And Click task name "AT-01" in kanban board screen
    Then Click time tracking button in edit issue screen
    And Enter invalid time "1her" in time tracking screen
    #Then Check mandatory red border is displayed or not in time tracking screen
    Then Close Task Management page

  @TC_62
  Scenario: Kanban Board:Edit Task:Time Tracking Invalid Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Select issue type "Task" from the dropdown in kanban board screen
    Then Enter valid id "AT-01" in search box in kanban board screen
    And Click task name "AT-01" in kanban board screen
    Then Click time tracking button in edit issue screen
    And Enter invalid time "1!@#" in time tracking screen
   # Then Check mandatory red border is displayed or not in time tracking screen
    Then Close Task Management page

  @TC_63
  Scenario: Kanban Board:Edit Task:Time Tracking Valid Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Select issue type "Task" from the dropdown in kanban board screen
    Then Enter valid id "AT-01" in search box in kanban board screen
    And Click task name "AT-01" in kanban board screen
    Then Click time tracking button in edit issue screen
    And Enter valid time "1h" in time tracking screen
    Then Enter valid description "Testing time lock" in time tracking screen
    And Click clear button in time tracking screen
    Then Close Task Management page

  @TC_64
  Scenario: Kanban Board:Edit Task:Raised By Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Select issue type "Task" from the dropdown in kanban board screen
    Then Enter valid id "AT-01" in search box in kanban board screen
    And Click task name "AT-01" in kanban board screen
    Then Click more fields button in edit issue screen
    And Click raised by dropdown in edit issue screen
    Then Select valid raised by "Thirumaran" option in edit issue screen
    Then Close Task Management page

  @TC_65
  Scenario: Kanban Board:Edit Task:Raised By Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Select issue type "Task" from the dropdown in kanban board screen
    Then Enter valid id "AT-01" in search box in kanban board screen
    And Click task name "AT-01" in kanban board screen
    Then Click more fields button in edit issue screen
    And Click raised by dropdown in edit issue screen
    Then Select valid raised by "Please Select" option in edit issue screen
    Then Close Task Management page

  @TC_66
  Scenario: Kanban Board:Edit Task:Fix Version Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Select issue type "Task" from the dropdown in kanban board screen
    Then Enter valid id "AT-01" in search box in kanban board screen
    And Click task name "AT-01" in kanban board screen
    Then Click more fields button in edit issue screen
    And Click fix versions dropdown in edit issue screen
    Then Select valid fix versions "Please select" option in edit issue screen
    Then Close Task Management page

  @TC_67
  Scenario: Kanban Board:Edit Task:Comments Valid Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Select issue type "Task" from the dropdown in kanban board screen
    Then Enter valid id "AT-01" in search box in kanban board screen
    And Click task name "AT-01" in kanban board screen
    Then Click Comments button in edit issue screen
    And Enter valid comments "Testing comments" in edit issue screen
    Then Click save button in comments tab
    Then Check success message is displayed or not in comments tab
    Then Close Task Management page

  @TC_68
  Scenario: Kanban Board:Edit Task:Comments Valid Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Select issue type "Task" from the dropdown in kanban board screen
    Then Enter valid id "AT-01" in search box in kanban board screen
    And Click task name "AT-01" in kanban board screen
    Then Click Comments button in edit issue screen
    And Enter valid comments "Testing comments" in edit issue screen
    # And Upload valid file in comments tab
    Then Click save button in comments tab
    Then Check success message is displayed or not in comments tab
    Then Close Task Management page

  @TC_69
  Scenario: Kanban Board:Edit Task:Comments Valid Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Select issue type "Task" from the dropdown in kanban board screen
    Then Enter valid id "AT-04" in search box in kanban board screen
    And Click task name "AT-04" in kanban board screen
    Then Click Status dropdown in edit issue screen
    And Select "BackLog" phase in the dropdown in edit issue screen
    And Click close button in edit issue screen
    Then Check backlog column contain "AT-04" issue or not in edit issue screen
    Then Close Task Management page

  @TC_70
  Scenario: Kanban Board:Edit Task:Comments Valid Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Select issue type "Task" from the dropdown in kanban board screen
    Then Enter valid id "AT-04" in search box in kanban board screen
    And Click task name "AT-04" in kanban board screen
    Then Click Status dropdown in edit issue screen
    And Select "In Progress" phase in the dropdown in edit issue screen
    And Click close button in edit issue screen
    Then Check In Progress column contain "AT-04" issue or not in edit issue screen
    Then Close Task Management page

  @TC_71
  Scenario: Kanban Board:Edit Task:Comments Valid Check
    Given Click Project button in the menu bar
    When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    And Click project name in project screen
    Then Select issue type "Task" from the dropdown in kanban board screen
    Then Enter valid id "AT-04" in search box in kanban board screen
    And Click task name "AT-04" in kanban board screen
    Then Click Status dropdown in edit issue screen
    And Select "For Review" phase in the dropdown in edit issue screen
    And Click close button in edit issue screen
    Then Check For Review column contain "AT-04" issue or not in edit issue screen
    Then Close Task Management page

  #@TC_72
  #Scenario: Kanban Board:Edit Task:Comments Valid Check
    #Given Click Project button in the menu bar
    #When Enter valid Timeline Project Name "Automation Testing" in the searchbox in Project screen
    #And Click project name in project screen
    #Then Select issue type "Task" from the dropdown in kanban board screen
    #Then Enter valid id "AT-04" in search box in kanban board screen
    #And Click task name "AT-04" in kanban board screen
    #Then Click Status dropdown in edit issue screen
    #And Select "Done" phase in the dropdown in edit issue screen
    #And Click close button in edit issue screen
    #Then Check Done column contain "AT-04" issue or not in edit issue screen
    #Then Close Task Management page
    
    @TC_73
  Scenario: Label:Search Check
    Given Click Label button in the menu bar
    When Enter valid label name "Website Creation" in searchbox in label screen
    Then Check entered label name "Website Creation" is displayed or not in label screen
    Then Close Task Management page
    
    @TC_74
  Scenario: Label:Sort By Check
    Given Click Label button in the menu bar
    When Click sort by dropdown in label screen
    Then Click "Label Name" option in label screen
    Then Close Task Management page
    
    @TC_75
  Scenario: Label:Add New:Close Check
    Given Click Label button in the menu bar
    When Click Add new button in label screen
    Then Click close button in add label popup
    Then Close Task Management page
    
    @TC_76
  Scenario: Label:Add New:Close Check
    Given Click Label button in the menu bar
    When Click Add new button in label screen
    Then Click save button in add label popup
    And Check mandatory message is displayed or not in add label popup
    Then Close Task Management page
    
    @TC_77
  Scenario: Label:Add New:Clear Check
    Given Click Label button in the menu bar
    When Click Add new button in label screen
    Then Enter valid label name in add label popup
    And  Click clear button in add label popup
    And Check entered details is cleared or not in add label popup
    Then Close Task Management page
    
    @TC_78
  Scenario: Label:Add New:Existing Check
    Given Click Label button in the menu bar
    When Click Add new button in label screen
    Then Enter existing valid label name "Testing" in add label popup
    And  Click save button in add label popup
    And Check error message is displayed or not in add label popup
    Then Close Task Management page
    
    @TC_79
  Scenario: Label:Add New:Save Check
    Given Click Label button in the menu bar
    When Click Add new button in label screen
    Then Enter valid label name in add label popup
    And  Click save button in add label popup
    And Check sucess message is displayed or not in add label popup
    Then Close Task Management page
    
    @TC_80
  Scenario: Label:Edit Label:Close button Check
    Given Click Label button in the menu bar
    When Enter valid label name "Enhancement" in searchbox in label screen
    And Click edit button in label screen
    Then Click close button in edit label popup
    Then Close Task Management page
    
    @TC_81
  Scenario: Label:Edit Label:Clear button Check
    Given Click Label button in the menu bar
    When Enter valid label name "Enhancement" in searchbox in label screen
    And Click edit button in label screen
    And  Click clear button in add label popup
    And Check entered details is cleared or not in add label popup
    Then Close Task Management page
    
    @TC_82
  Scenario: Label:Edit Label:Update button Check
    Given Click Label button in the menu bar
    When Enter valid label name "Enhancement" in searchbox in label screen
    And Click edit button in label screen
    And Modify valid details in edit label popup
     And Click update button in edit label popup
    And Check sucess message is displayed or not in edit label popup
    Then Close Task Management page
    
    @TC_83
  Scenario: Label:Delete Label:Cancel Check
    Given Click Label button in the menu bar
    When Enter valid label name "Manual Testing" in searchbox in label screen
    And Click delete button in label screen
    And Click cancel button in delete label popup
    Then Close Task Management page
    
    @TC_84
  Scenario: Label:Delete Label:Delete Check
    Given Click Label button in the menu bar
    When Enter valid label name "Manual Testing" in searchbox in label screen
    And Click delete button in label screen
    And Click delete button in delete label popup
    Then Close Task Management page

    