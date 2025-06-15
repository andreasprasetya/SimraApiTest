Feature: API Group
    Background:
        Given Preparing header for authorization
@High
    Scenario: Get all group from catalogs
    Given Preparing header for authorization
    When I access group with credential
    Then I received response from the server

    @NewFeature
    Scenario: Create group with payload
    Given Preparing header for create group
    When I post data payload to server
    Then I received response 201 from the server