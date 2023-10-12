#!/bin/bash

# Define parameters (you can set these as needed)
anonymousExecution='false'
ccmv='v1'

# Get the current directory
currentLocation=$(pwd)

# Change directory to the parent directory
cd ../..

# Run Docker container
docker run -d --name backend -p 9900:9900 534369319675.dkr.ecr.us-west-2.amazonaws.com/sl-tools-mockserver:latest

# Run Gradle build
./gradlew :sl-synth-app:clean :sl-synth-app:test -i \
    --tests 'i00test.sealights.synth.test.predefined.Synchronous*' \
    "-DcodeCoverageManagerVersion=$ccmv" "-DanonymousExecution=$anonymousExecution" \
    -DenableSlPlugin -DtestRunId=1000m_noSL_sync

# Change back to the original directory
cd "$currentLocation"