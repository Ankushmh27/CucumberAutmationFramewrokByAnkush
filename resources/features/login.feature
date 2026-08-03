Feature: Login Functionality


@chrome @testNG
  @Admin_Login_Positive
  Scenario Outline:: Valid Login
    Given User launches the application
    When User enters username "<username>" and password "<password>"
    And User clicks Login button
    Then User should see Dashboard "<message>"

    Examples:
      | username | password | message          |
      | admin    | admin1234 | Login Successful |

@chrome @testNG
  @Admin_Login_DataTest
  Scenario Outline: Validate Login test data
    Given User launches the application
    When User enters username "<username>" and password "<password>"
    And User clicks Login button
    Then User should see Dashboard "<message>"

    Examples:
      | username | password | message             |
      | admina    | admin123 | Login Successful    |
      | admin    | admin1234  | Login Unsuccessful  |
      | admin    | admin123 | Invalid Credentials |
