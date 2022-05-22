Feature: New account on the hotel website Qlo

  Scenario Outline: Creating an account on the website https://hotel-testlab.coderslab.pl/

    Given The user is on home page
    When The user clicks on SignIn button
    And User inputs an email address "<email>" and clicks the CreateAnAccount button
    And User completes the registration form "<name>", "<surname>", "<password>" and clicks Register button
    Then User account has been created and the user with "<name>" is logged into his account
    Examples:
      | email                   | name  | surname   | password |
      | test843534@test.pl      | Jan   | Kowalski  | haslo1   |
      | testowanie087@gmail.com | Ewa   | Nowak     | haslo2   |
      | testtestst098@test.pl   | Kamil | Dobrowski | haslo3   |