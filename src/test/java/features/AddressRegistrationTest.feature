Feature: Address registration

  Scenario Outline: Add address to user
    Given Human is on "https://hotel-testlab.coderslab.pl/en/" home page
    When Human clicks on Sign In button
    And Valid user inputs an email address "<email>" and clicks the CreateAnAccount button
    And Valid user completes the registration form "<name>", "<surname>", "<password>" and clicks Register button
    And Valid user account has been created and the user with "<name>" is logged into his account
    And User is logged out
    And User inputs an email address "<email>", "<password>" and clicks Sign in button
    And User clicks on MyAddresses then on AddANewAddress button and fills up the form and clicks Save button
    Then User address has been added
    Examples:
      | email                 | name  | surname   | password |
      | 123045vbnrd4@test.pl   | Jan   | Kowalski  | haslo1   |
 #     | teste087@gmail.com | Ewa   | Nowak     | haslo2   |
 #     | tttst098@test.pl   | Kamil | Dobrowski | haslo3   |
