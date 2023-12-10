@tag
Feature: Purchase the order from e-commerce website
  I want to use this template for my feature file
  
  Background:
  Given I landed on the e-commerce page

  @Regression
  Scenario Outline: Positive test of submitting the order
    Given Logged in with <username> and <password>
    When I add the <product> to Cart
    And Checkout <product> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on the confirmation page

    Examples: 
      | username                | password    | product         |
      | dummy.account@email.com | Qazxsw21    | ZARA COAT 3     |
      | anshika@gmail.com       | Iamking@000 | ADIDAS ORIGINAL |
