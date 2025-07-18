#!/bin/bash

uname -a

for i in 2.24.3 2.25.1
do
    echo ""

    echo -n "Testing $i with bad Log4j 1.2 properties config: "
    VER=$i ./gradlew -q --console=plain badLog4j1
    echo ""

    echo -n "Testing $i with bad Log4j 2.x properties config: "
    VER=$i ./gradlew -q --console=plain badLog4j2

    echo -n "Testing $i with wrong properties config version: "
    VER=$i ./gradlew -q --console=plain wrongVersion
done

exit 0
