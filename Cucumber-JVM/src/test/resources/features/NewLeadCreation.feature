
Feature: New Lead Creation feature file
@wip
  Scenario: Creating New Lead using valid details
    Given I am on Orion CLS Home page
    When I click on Admission Link
    And I click on Admission Manager and Add New Lead/Referral Link
    When I fill all the required details for New Referral
    Then I should be able to see the created new Lead
   
 Scenario: Creating New Lead using invalid details
    Given I am on Orion CLS Home page
    When I click on Admission Link
    And I click on Admission Manager and Add New Lead/Referral Link
    When I fill invalid details for New Referral
    Then I should be able to see error message