Meta:

Narrative: I want to get detailed disruptions in any date at London
As a bike user
I want to know where are the disruptions in any day at London



#Gets a list of disrupted streets. If no date filters are provided, current disruptions are returned
Scenario: Getting data about disrupted streets in London today
Given I want to know the streets that were disrupted between 10 Mar 2018 and 12 Mar 2018
When I select the dates
Then I should get the Queen Victoria Street (EC2R,EC3V)

Scenario: Getting data about disrupted streets in London today
Given I want to know the streets that were disrupted yesterday
When I select yesterdays date
Then I should get the streets that were disrupted yesterday


Scenario: Getting data about disrupted streets in London today
Given I want to know the streets that are disrupted last monday
When I select last monday date
Then I should get the streets that were disrupted last monday