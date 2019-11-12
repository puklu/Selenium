#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@smoke
Feature: LogIn - As a tester I want to validate LogIn feature on ZeroBank

  @reg
  Scenario: As a user given a valid id and password I should be able to login
    Given An application
    And valid username
    And valid password
    When i enter username as "username"
    And i enter password as "password"
    And i click on "sign in" button
    Then I should be able to login

  #   And i land on "Account activity page"
  #  @error
  # Scenario Outline: As a I should be able to validate error msg for invalid login id and password
  #  Given invalid username
  #  And invalid password
  #  When i enter username as <loginID>
  #  And i enter password as <password>
  #  And i click on "sign in" button
  #  Then I should get an error msg "Invalid ID/Password"

  #  Examples: 
  #    | name    | value    | status  |
  #    | loginID | username | success |
  #    | name2   |        7 | Fail    |
