Meta:

Narrative:
In order to evaluate bank functionality
As the application user
I want to see the generated messages of transactions
So that I can achieve a business goal

Scenario: Should list transactions messages after execution
Given I want to read the generated messages of transactions on console
When I execute the application
Then I see the complete information about transactions

Scenario: Should list message complete information
Given I want the complete information inside a message
When The message is generated inside system
Then I see a message with all fields of information

Scenario: Should create the message after transaction is ended
Given I want to create a message object after transaction
When The transaction is ended
Then The message object is created

Scenario: Should process message after it is created
Given I want the message to be processed
When The message is created
Then I want the message change the Transactions subject status

Scenario: Should process the transaction correctly
Given I want to process the transaction correctly
When The transaction is created
Then I want to check if user balance is consistent

Scenario: Audit module should write transaction messages to txt file
Given I want the transaction messages written in a txt file
When The message change the Transaction subject status
Then I want the system to write in a txt file

Scenario: 