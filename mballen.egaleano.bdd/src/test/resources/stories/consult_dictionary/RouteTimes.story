Ask for a route time on bicycle

Narrative:
In order to administrate my time
As a bicycle rider of the London city
I want to know the time I'll spent from a given address to another

Scenario: Get estimated route time
Given I am in 76 Windsor Dr, Orpington BR6 6HF, UK
And I am going to the address 3 Woodside, Orpington BR6 6JR, UK
When I ask for the route time
Then The answer from the program should be 1 mins


Scenario: Get estimated route time for a non-existing address
Given I am in 123 fake street
And I am going to the address 3 Woodside, Orpington BR6 6JR, UK
When I ask for the route time
Then The answer from the program should be Sorry, we can't find a journey matching your criteria
