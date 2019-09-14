#!/bin/bash

(cd ./src/client && CI=true npm run test && npm start && cd .. && cd ..)