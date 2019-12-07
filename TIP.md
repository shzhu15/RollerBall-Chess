# Board Layout

The board indexing is shown below. The x values are represented by the column headers and the y values by the row headers. 

| |   0  |  1  |  2  |  3  |  4  |  5  |  6  |
|-|------|-----|-----|-----|-----|-----|-----|
|0|      |     |     |     |     |     |     | 
|1|      |     |     |     |     |     |     |
|2|      |     | x   | x   |  x  |     |     |
|3|      |     |  x  | x   |  x  |     |     |
|4|      |     |  x  | x   | x   |     |     |
|5|      |     |     |     |     |     |     |
|6|      |     |     |     |     |     |     |


# API Descriptions
This document describes the standard format of all API requests and responses. 
To simplify interaction between client and server the JSON format is used. 
## register (POST)
When a user is attempting to create a new account the client sends a JSON object with email, UserID and password elements
```
{
    "email" : "email@email.com"
    "UserID" : "exampleUserID"
    "password" : "Example Password"
}
 
```

Upon receiving the request, the server checks that the user does not already exist, creates 
the user and sends a response with the following JSON Object:

```
{
    "email" : "email@email.com"
    "UserID" : "exampleUserID"
    "password" : "Example Password"
    "success" : {boolean : "if false, reason for failure"} 
}
```

## login (POST)
 When a user is attempting to login to an existing account, the client sends a JSON Object with email and password elements:
 ```
 {
     "email" : "email@email.com"
     "password" : "Example Password"
 }
  
 ```

Upon receiving the request, the server checks that the email and password correspond to an existing account. If the 
account exists the account data is fetched and returned to the client with the following response:

 ```
 {
     "email" : "email@email.com"
     "UserID" : "exampleUserID"
     "password" : "Example Password"
     "success" : boolean 
     "activeGameIDs" : []
 }
 ```
## game (POST)
Will update the current game id with the game that you give it
```
{
    "id": "123"
    "board": [BOARD OBJECT]
    "p1": "player1@email.com"
    "p2": "player2@email.com"
}
```
Returns message upon successful or unsuccessful update

## game (GET)
Returns the current game objects that belong to a player
```
{
    "email": "example@email.com"
}
```
The return type is three separate maps denoted by the key words "sent", "pending", and "active"

```
{
   "pending":[
      {
         "id":902013461,
         "p1":"daniel@email.com",
         "p2":"alex@email.com",
         "ready":false
      }
   ],
   "active":[
      {
         "id":203265557,
         "p1":"daniel@email.com",
         "p2":"alex@email.com",
         "ready":true
      }
   ],
   "sent":[
      {
         "id":1404634779,
         "p1":"alex@email.com",
         "p2":"daniel@email.com",
         "ready":false
      },
      {
         "id":75299431,
         "p1":"alex@email.com",
         "p2":"daniel@email.com",
         "ready":false
      }
   ]
}
```

So on the client, some code to process this might look like:
```
request.pending.forEach((game) => {
    console.log("This is my pending game!", game);
}
```

## sendInvite (POST)
This will create a brand new game between two players, but won't be set to ready unless acceptInvite is called with the game id
```
{
    "p1": "player1@email.com",
    "p2": "player2@email.com"
}
```

Returns string including the newly generated random int for the gameId
## acceptInvite (POST)
Starts the current game (doens't have error checking currently)
```
{
    "id": "12345678"
}
```
Returns success string

## Move(POST)
Moves the piece located at oldX/oldY to newX/newY. Requires the name of the player so that people can't play for eachother
```
{
    "id": 12345678
    "newX": 1
    "newY": 1
    "oldX": 2
    "oldY": 1
    "player": "jared"
}
```

# Saved File Descriptions
Two files will be saved on the server, one for storing information about all registered users of the application, and another to save all games past and present.
The files will be loaded when the server starts, and the files will be saved each time the Player or Game data is modified. 

## Player file Specification
Each player will contain:
- Email
- Username
- Password
- Array of Game IDs
```
   [
       { "email" : "email@email.com", "userId" : "surprise123", "password" : "securePassword", "gameIDs" : [1,2,3]},
       { "email" : "anotherexample@email.com", "userId" : "sohip97", "password" : "PaSsWoRd", "gameIDs" : [3,6,7]}
   ]
```

