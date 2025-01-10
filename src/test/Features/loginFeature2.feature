Feature: Login functionality

  Scenario Outline: Validate login with dynamic credentials
    Given I load test data for "<username>" and "<password>"
    When I test login
    Then I should see the dashboard for "<username>"

    Examples:
      | username | password |
