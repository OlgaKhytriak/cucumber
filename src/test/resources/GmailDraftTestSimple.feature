Feature: Gmail draft test
In order to test Gmail draft
user should be able to create draft and sent it

Scenario: user login
Given user navigates to gmail login page
When user types login and password
Then user should see gmail homepage
When user creates draft
Then draft should be on the drafts page
When user sends draft
Then the draft should be on the sent mails page


Scenario: create and sent draft
Given user navigates to gmail login page
When user types login "ForHometaskTest4@gmail.com" and password "12345aKids"
Then user should see gmail homepage
When user creates draft
Then draft should be on the drafts page
When user sends draft
Then the draft should be on the sent mails page


