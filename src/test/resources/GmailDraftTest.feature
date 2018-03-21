Feature: Gmail draft test
In order to test Gmail draft
user should be able to create draft and sent it

#@smokeTest
Scenario Outline: create and sent draft
Given user navigates to gmail login page
When user types login <login> and password <password>
Then user should see gmail homepage
When user creates draft
Then draft should be on the drafts page
When user sends draft
Then the draft should be on the sent mails page
Examples: users data
|   login            | password   |
|  ForHometaskTest3  | 12345aKids |
|  ForHometaskTest2  | 12345aKids |
|  ForHometaskTest1  | 12345aKids |

