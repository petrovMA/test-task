Feature: Check players sorting

  Scenario: Check players sorting
    Given authorize with login 'admin1' and password '[9k<k8^z!+$$GkuP'
    When open list of players
    Then sort list of players by name
    And check that list of players sorted correctly
