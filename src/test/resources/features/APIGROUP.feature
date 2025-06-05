Feature: API Group

  Scenario: Get all group from catalogs
    Given Preparing header for authorization
    When I access group with credential
    Then I received response from the server