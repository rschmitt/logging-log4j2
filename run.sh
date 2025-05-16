#!/bin/bash

for i in 2.20.0 2.21.0 2.21.1 2.22.0 2.22.1 2.23.0 2.23.1 2.24.0 2.24.1 2.24.2 2.24.2 "2.25.0-SNAPSHOT"
do
    echo "Testing $i"
    VER=$i ./gradlew -q run
    echo ""
done
