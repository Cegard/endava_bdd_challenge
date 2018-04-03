Meta:

Narrative: I want to get detailed disruptions in any date at London
As a bike user
I want to know where are the disruptions in any day at London

#Gets a list of disrupted streets. If no date filters are provided, current disruptions are returned
Scenario: Getting data about disrupted streets in London between dates
Given I want to know the streets that were disrupted between 10 Mar 2018 and 12 Mar 2018
When I send the request to the API with the dates
Then I should get the name of the street disrupted on that date

Scenario: Getting data about disrupted in real time
Given I want to know there is a disruption given A406, A2
When I send the request to the API with the parameter
Then I should get [A206] Greenwich High Road (SE10) (Greenwich) where is disrupted

