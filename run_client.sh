#!/bin/bash

(cd ./src/client && CI=true  && REACT_APP_SERVER_ADDR=http://localhost:4567/ npm start && cd .. && cd ..)