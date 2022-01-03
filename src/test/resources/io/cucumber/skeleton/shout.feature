Feature: Shout

  Todo:
  - Only shout to people

  Background:
    Given a person named Lucy
    And a person named Sean

  Rule: Shouts can be heard by other users
  Scenario: Listener within range
    Given Lucy is located 15 metre from Sean
    When Sean shouts "free bagels at Sean's"
    Then Lucy should hear Sean's message

  Scenario: Listener hear a diff message
    Given Lucy is located 15 metres from Sean
    When Sean shouts "Free Coffee"
    Then Lucy should hear Sean's message

  Scenario: Listener out of range and doesn't hear a message
    Given Mike is standing 150 metres from Sean
    When Sean shouts "Free Coffee"
    Then Mike shouldn't hear Sean's message