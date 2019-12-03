#!/bin/bash

(cd ./src/client && CI=true  && REACT_APP_SERVER_ADDR=http://76.120.116.116:4567/ npm start && cd .. && cd ..)