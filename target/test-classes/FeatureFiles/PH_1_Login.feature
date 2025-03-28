Feature: Login

  #Background: Login
  #Given To Check Login user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
  #When To Check Login Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@123"
  #And Click the Login button To Check Login
  #Then Click Login button
  @TC_01
  Scenario: Login1:Login Check
    Given To Check Login user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When To Check Login Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@123"
    And Click the Login button To Check Login
    Then Check display homepage or not To Check Login
    Then Close Login page

  @TC_02
  Scenario: Login2:Sign Out Check
    Given To Check Login user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When To Check Login Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@123"
    And Click the Login button To Check Login
    Then Click User logo button in Top right corner
    And Click SignOut button
    Then Check login page is displayed or not using assert
    Then Close Login page

  @TC_03
  Scenario: Login3:Invalid Check
    Given To Check Login user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When To Check Login Enter Invalid username and valid password are "thirumaran1@sankarasoftware.com" and "Thirumaran@123"
    And Click the Login button To Check Login
    Then Check alert message is displayed or not in login page
    Then Close Login page

  @TC_04
  Scenario: Login4:Invalid Check
    Given To Check Login user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When To Check Login Enter valid username and Invalid password are "thirumaran@sankarasoftware.com" and "Thirumaran12345"
    And Click the Login button To Check Login
    Then Check alert message is displayed or not in login page
    Then Close Login page

  @TC_05
  Scenario: Login5:Invalid Check
    Given To Check Login user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When To Check Login Enter Invalid username and Invalid password are "0211thiru@gmailss.com" and "Thirumaran12345"
    And Click the Login button To Check Login
    Then Check alert message is displayed or not in login page
    Then Close Login page

  @TC_06
  Scenario: Login6:Without Password Check
    Given To Check Login user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When To Check Login Enter username only "thirumaran@sankarasoftware.com"
    And Click the Login button To Check Login
    Then Check alert toast message is displayed in password tab or not in login page
    Then Close Login page

  @TC_07
  Scenario: Login7:Without Mail Id Check
    Given To Check Login user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When To Check Login Enter password only "Thirumaran@123"
    And Click the Login button To Check Login
    Then Check alert toast message is displayed in email tab or not in login page
    Then Close Login page

  @TC_08
  Scenario: Login8:Forget Password Check
    Given To Check Login user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When Without enter email id click Forget password button
    Then Check alert toast message is displayed or not in login page
    Then Close Login page

  @TC_09
  Scenario: Login9:Forget Password Check
    Given To Check Login user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When To Check Forget Password Enter valid email id "developer@yopmail.com"
    And click Forget password button
    Then Click Ok button
    And Check Login page is displayed or not
    Then Close Login page

  @TC_10
  Scenario: Login10:Lock Account
    Given To Check Login user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When Enter username and password are "0211thiru@gmail.com" and "Thirumaran@001"
    And Click the Login button To Check Login
    Then Check alert message is displayed or not
    And Click the Login button To Check Login
    Then Check alert message is displayed or not
    And Click the Login button To Check Login
    Then Check alert message is displayed or not
    And Click the Login button To Check Login
    Then Check alert message is displayed or not
    Then Close Login page

  @TC_11
  Scenario: Login11:Lock Account
    Given To Check Login user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When Enter username and password are "0211thiru@gmail.com" and "Thirumaran@001"
    And Click the Login button To Check Login
    Then Check alert message is displayed or not
    Then Close Login page

  @TC_12
  Scenario: Login12:Unlock Account
    Given To Check Login user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@123"
    And Click the Login button To Check Login
    Then Click Admin button to unlock account
    And Click Users button to unlock account
    And Search valid username "0211thiru@gmail.com" in the searchbox to unlock the account
    Then Click edit button to unlock the account
    And Click unlock button to unlock the account
    Then Close Login page

  @TC_13
  Scenario: Login13:Enter button check
    Given To Check Login user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When Enter valid username and valid password are "thirumaran@sankarasoftware.com" and "Thirumaran@123"
    And Press ENTER button
    Then Check landing page after press Enter button
    Then Close Login page

  @TC_14
  Scenario: Login14:2FA Enabled User Check
    Given To Check Login user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When Enter valid username and valid password are "0211thiru@gmail.com" and "Thirumaran@1234"
    And Click the Login button To Check Login
    Then Check the landing page using assert function
    Then Close Login page

  @TC_15
  Scenario: Login15:With Inactive User Check
    Given To Check Login user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When Enter inactive username "0211thiru@gmal.com"
    And click Forget password button
    Then Check alert message is displayed or not for inactive in login page
    Then Close Login page

  @TC_16
  Scenario: Login16:With Inactive User Check
    Given To Check Login user is navigating to ProjectHub URL is "http://192.168.1.33/proj/"
    When Enter inactive username and valid password are "0211thiru@gmal.com" and "Thirumaran@001"
    And Click the Login button To Check Login
    Then Check alert message is displayed or not
    Then Close Login page
