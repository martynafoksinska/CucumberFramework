Feature: Creating new account

  Scenario: Create new account on https://hotel-testlab.coderslab.pl/ page
    Given User is on home page
    When User clicks on Sign In button
    And User writes e-mail address into input and clicks Create An Account button
    And User fills up the registration form and click Register button
    Then Account has been created