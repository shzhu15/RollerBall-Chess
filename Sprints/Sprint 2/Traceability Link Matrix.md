This document tracks code written vs user stories in tabular form. The code written is split into two tables, one for the client side and one for the server side

# Traceability Link Matrix - Server Side

 | User Story                                                                     | GameApi class | Game class | Board Class | Piece super class |  Player Class |
 | -------------------------------------------------------------------------------| ------------- | ---------  | ----------- | ----------------- | --------------|
 | I want to be able to move a piece                                              |            x  |            |             |               x   |               |
  | I want to only be able to move a piece to a legal spot on the board           |           x   |            |             |      x            |               | 
  | I want to be able to see the game board associated with the game I am playing |       x       |            |             |                   |               |
 | I want to be able to start a match                                             |         x     |            |             |                   |               |
 | I want to be able to register for an account                                   |         x     |            |             |                   |    x          |
 | I want to be able to login to my account                                       |          x    |            |             |                   |x              |
 | I want to be able to logout of my account                                      |          x    |            |             |                   |               |
 | I want my past and current games to be displayed after logging in              |    x          |            |             |                   |               |
 | I want to be able to invite my friend to a match                               |       x       |            |             |                   |               |
 | I want to be able to accept a new game invitation                              |      x        |            |             |                   |               |
 | I want to be able to reject an invitation                                      |     x         |            |             |                   |               |
 | I would like to know if an invitation I have sent has been rejected or accepted|      x        |            |             |                   |               |
 | I want to be able to view a history of all games that I have played            |      x        |            |             |                   |               |

# Traceability Link Matrix - Client Side

 | User Story                                                                          | Login class   | Register class | Home Class  | App               | Board               | Square         | History  |
 | ------------------------------------------------------------------------------------| ------------- | ---------      | ----------- | ----------------- | --------------------|----------------| -------- |
 | I want to be able to start a match                                                  |               |                |             |                   |                     |                |          |
  | I want to be able to move a piece                                                  |               |                |             |                   |                     |                |          |
  | I want to only be able to move a piece to a legal spot on the board                |               |                |             |                   |                     |                |          |
  | I want to be able to see the game board associated with the game I am playing      |               |                |             |                   |    x                 |                |          |
  | I want to be able to register for an account                                       |               |     x           |             |                   |                     |                |          |
  | I want to be able to login to my account                                           |           x    |                |             |                   |                     |                |          |
  | I want to be able to logout of my account                                          |               |                |        x     |                   |                     |                |          |
  | I want my past and current games to be displayed after logging in                  |               |                |             |                   |                     |                |      x    |
  | I want to be able to invite my friend to a match                                   |               |                |             |                   |                     |                |          |
  | I want to be able to accept a new game invitation                                  |               |                |             |                   |                     |                |          |
  | I want to be able to reject an invitation                                          |               |                |             |                   |                     |                |          |
  | I would like to know if an invitation I have sent has been rejected or accepted    |               |                |             |                   |                     |                |          |
  | I want to be able to view a history of all games that I have played                |               |                |             |                   |                     |                |    x      |
 
