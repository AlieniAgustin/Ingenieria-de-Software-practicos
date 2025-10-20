Feature: Is it Sunday yet?
  Everybody wants to know when it's Sunday

  Scenario: Sunday is Sunday
    Given Today is Sunday
    When I ask the system whether it's Sunday
    Then The answer should be true
