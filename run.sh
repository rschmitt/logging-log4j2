#!/bin/bash

uname -a
echo ""

for i in 2.20.0 2.21.1 2.22.1 2.23.1 2.24.3 2.25.0 2.25.1
do
    echo "Testing $i"
    VER=$i ./gradlew -q run
    echo ""
done

exit 0
