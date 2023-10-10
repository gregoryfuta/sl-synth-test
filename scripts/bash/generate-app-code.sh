#!/bin/bash
currentLocation=$(pwd)
cd ../..

bash gradlew clean :sl-code-gen:test --tests 'io.sealights.codegen.*' \
  -DgeneratorPackageName="i0.sealights.synth.app" \
  -DgeneratorTestPackageName="i00test.sealights.synth.test" \
  -DgeneratorModuleCount=3 \
  -DgeneratorClassCount=3 \
  -DgeneratorMethodCount=3 \
  -i

cd "$currentLocation"
