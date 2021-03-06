Lookup a station status, street and landmarks

Narrative:
In order to know a station street, landmarks and status
As a bike user
I want to look up for the station street, landmarks and status

Scenario: Looking up for the street and nearby landmarks of a given station
Given I want to know the street of Hoxton station and nearby landmarks
When I insert the station name as the query in API
Then I should get Fanshaw Street inside Json object response

Scenario: Looking for a station status and occupancy
Given I want to know the state of BikePoints_19 and its occupancy
When I request API for the state of BikePoints_19
Then I should get station status and its occupancy