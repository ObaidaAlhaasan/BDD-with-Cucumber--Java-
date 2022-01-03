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


    Scenario: Listener is withing range
      Given the range is 100
      And people are located at
        | name | location |
        | Sean | 0        |
        | Lucy | 50       |
      When Sean shouts
      Then Lucy should hear a shout


  Rule: Listener should be able to hear multiple shouts

    Scenario: Two shouts
      Given a person named Sean
      When Sean shouts "Free bagels!"
      And Sean shouts "Free toast!"
      Then Lucy hears the following messages:
        | Free bagels! |
        | Free toast!  |


  Rule: Maximum length of msg is 180 characters

    Scenario: Msg is too long
      Given a person named Sean
      And a person named Lucy
      When Sean shouts the following message
      """
    This is a really long msh
    123456789010101234567890101
    012345678901010123456789010101234567890101012345678901010123456789010101234567890101012345678901010123456789010101
    234567890101012345678901010123456789010101234567890101012345678901010123456789010101234567890101012345678901010"
      """
      Then Lucy should not hear a shout