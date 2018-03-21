Ask for a route time on bicycle

Narrative:
In order to administrate my time
As a bicycle rider of the London city
I want to know the time I'll spent from a given address to another

Scenario: Get estimated route time
Given I am in 6 Tant Ave, London E16, Reino Unido
And I am going to 23 Vincent St, London E16 1LS, Reino Unido
When I ask for the route time
Then The answer I get is 1 minutes


Scenario: Get estimated route time for a non-existing address
Given I am in 123 fake street, UK
And I am going to 3 Woodside, Orpington BR6 6JR, UK
When I ask for the route time
Then The status code I get is 300


Scenario: Get estimated route time for a path of more than 10km
Given I am in 16 Andrewes Gardens, London E6 5TG, Reino Unido
And I am going to Serpentine Rd, London W2 2UH, Reino Unido
When I ask for the route time
Then The answer I get is 75 minutes
And it can differ within 20 minutes