#!/bin/bash

echo "Executing Sample UI Test"

cd sample-UI-se
mvn -f pom.xml clean test

rm -rf ../target.zip;
zip -r ../target.zip target;

targetArchivePath="target.zip"
~                                    
