@tag
Feature: Error validation
  I want to use this template for my feature file
  
  @ErrorValidation
  Scenario Outline: Positive test of submitting the order
    Given I landed on the e-commerce page
    When Logged in with <username> and <password>
    Then "Incorrect email or password." message is displayed
    
    Examples: 
      | username                | password |
      | anshika@gmail.com       | Iamking@ |