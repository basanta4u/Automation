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
Feature: Title of your feature
  I want to use this template for my APM login & validation test

  @Selenium
  Scenario Outline: Navigate to APM & Login
    Given I want to navigate to APM url
    And user provided with "<uid>"
    And pwd provided with "<pwd>"
    And tenant provided with "<tenant>"
    When I click on submit button
    Then I validate the apm botton
    And click on apm bottom

    Examples: 
      | uid        | pwd         | tenant                       |
      | automation | interOP@123456 | Jyotsna.Akula@automation.com |

  @Selenium
  Scenario: Click on Security Tab
    Given I want to navigate to APM url
    And user provided with "automation"
    And pwd provided with "interOP@123456"
    And tenant provided with "Jyotsna.Akula@automation.com"
    When I click on submit button
    Then click on apm bottom
    Given close the popup
    When I click on security tab
    Then security list page should display
