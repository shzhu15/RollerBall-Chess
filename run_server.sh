#!/bin/bash

mvn clean package
java -cp target/cs414-*.jar com.cs414.blueberries.GameApi