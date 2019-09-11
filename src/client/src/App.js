import React from 'react';
import request from 'request';
function dummyApiCall() {

    request('http://localhost:4567/hello', function (error, response, body) {
        console.log('error:', error);
        console.log('statusCode:', response && response.statusCode);
        console.log('body:', body);
    });
}

function App() {
  return (
    <div>
      <header>
        <p>
            Here is a barebones setup that calls the "hello world" endpoint as long as you are running the java server (check the console)
            {dummyApiCall()}
        </p>
      </header>
    </div>
  );
}

export default App;
