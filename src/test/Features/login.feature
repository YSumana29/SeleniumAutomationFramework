Feature: Login Test Cases

  Scenario Outline: Verify that user is able to login successfully.
    Given the user is on login page
    Then check if the page title is correct
    When I click on element "<userName>"
#Then I click on the <userName> field and send data <>
#Then I click on the <userName> field and send data <>
#Then I click on Submit

    Examples:
      | username | password |
      | sumana   | password |
