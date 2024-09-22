Feature: Login Functionality for OpenCart E-Commerce Website

  As a user of the Open cart website i want to able to login to my account
  So that i can access my account related features and orders



  Background:
    Given I am on the Open cart login page


  Scenario: Successful login with valid credentials
    Given I have entered a valid name and password
    When I clicked on the login button
    Then I should be logged in Successfully


  Scenario Outline: Unsuccessful login with Invalid or empty credentials
    Given I have entered a Invalid "<UserName>" and "<Password>"
    When I clicked on the login button
    Then I should see error message indicating "<Error_Message>"


    Examples:
        | UserName               | Password | Error_Message                                         |
        | Invalid@gmail.com      | Invalid1 | Warning: No match for E-Mail Address and/or Password. |
        | abcdef@yahoo.com       | Invalid2 | Warning: No match for E-Mail Address and/or Password. |
        | Invalidemail@gmail.com | Invalid3 | Warning: No match for E-Mail Address and/or Password. |

  Scenario: Navigating to forgot password page
    When I click on the Forgotten Password link
    Then I should be redirect to password reset page
