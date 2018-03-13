Lookup a station status, street and landmarks

Narrative:
In order to know a station street, landmarks and status
As a bike user
I want to look up for the station street, landmarks and status



Scenario: Looking up for the street and nearby landmarks of a given station
Given I want to know the street of Hoxton station and nearby landmarks
When I insert Hoxton as the query in API
Then I should get Geffrye street and Geffrye museum

Scenario: Looking for a station status and occupancy
Given I want to know the state of Soho Square station and its occupancy
When I insert Soho Square in the search field
Then I should get Soho Square status and its occupancy