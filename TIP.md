# API Descriptions
This document describes the standard format of all API requests and responses. 
To simplify interaction between client and server the JSON format is used. 
## Registration Request
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

## Login Request
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

