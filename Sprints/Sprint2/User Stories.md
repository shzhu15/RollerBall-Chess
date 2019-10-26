# Sprint 2 User Stories
  - After discussion with product owner after sprint 1, the teams user stories and tasks changed drastically. 
  - The new user stories and tasks are shown below in order of Priority
  - The associated ZenHub task number is shown in parentheses next to each user story 
  
## (#61) As a user, I want to be able to move a piece 
  - Implement UI code to allow user to specify which piece they want to move to where
  - Implement code on server side to update location of piece being moved
  - Implement API end point to allow client to communicate to server which piece to move

  
## (#5) As a user, I want to be able to start a match
  - Create UI to allow user to start a new match
  - Send API request to server to let it know about the game
## (#60) As a user, I want to only be able to move a piece to a legal spot on the board 
  - Implement legal move checks for Pawn
  - Implement legal move checks for Rook
  - Implement legal move checks for Bishop
  - Implement legal move checks for King
  - Add legal move checking to the move API endpoint
  
## (#62) As a user, I want to be able to see the game board associated with the game I am playing
  - Implement UI code to display the board
  - Update the board anytime a player moves a piece
  
## (#78) As a user, I want to know when the game has ended
  - Add game end checks to the King Class. 
  
## (#63) As a user, I want to be able to register for an account 
  - Create UI for account registration
  - Add API endpoint for registering
  - Define register API in [TIP.md](https://github.com/hamjared/cs414-f19-001-Blueberries/blob/master/TIP.md)
  - Send register API request from client to server
  
## (#64) As a user, I want to be able to login to my account 
  - Create UI for account login
  - Add API endpoint for login
  - Define login API in [TIP.md](https://github.com/hamjared/cs414-f19-001-Blueberries/blob/master/TIP.md)
  - Send login API request from client to server
  - Add password check to Player class on server side
 
## (#66) As a user, I want to be able to logout of my account
- Create a logout button on the client side

## (#79) As a user, I want to know when it is my turn to play

## (#80) As a user, I want to know who won the game I just finished

## (#65) As a user, I want my past and current games to be displayed after logging in 
 
## (#67)  As a user, I want to be able to invite my friend to a match  

## (#68) As a user, I want to be able to accept a new game invitation 

## (#69) As a user, I want to be able to reject an invitation
 
## (#70) As a user, I would like to know if an invitation I have sent has been rejected or accepted 

## (#71) As a user, I want to be able to view a history of all games that I have played
