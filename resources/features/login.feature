Feature: Login Functionality

  @Admin_Login_Positive
  Scenario: Valid Login

    Given User launches the application

    When User enters username and password

    And User clicks Login button

    Then User should see Dashboard