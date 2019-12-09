# Developer's Guide
To begin working on our project on a linux machine, execute the following workflow:

#### 1. Ensure your machine has Git, maven, and npm are installed

#### 2. Execute the following commands:

```
git clone https://www.github.com/hamjared/cs414-f19-001-Blueberries
cd cs414-f19-001-Bluberries/src/client
npm install
cd ../..
```

#### 3. Make changes

#### 4. Run the server and client with the following commands (also runs all tests)

```
./run_server.sh
./run_client.sh
```

#### 4. Run the client in hosted mode (so that it can be used outside of local host)
  - First edit the file to contain the IP address and port number of the machine running the server
  - Then run:
  ```
./run_client_hosted_server.sh
```

