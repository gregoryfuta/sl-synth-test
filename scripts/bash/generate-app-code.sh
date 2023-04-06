#!/bin/bash

cd ../../sl-code-gen || exit 101

./gradlew -DgeneratorPackageName="i0.sealights.synth.app" \
          -DgeneratorModuleCount=2 \
          -DgeneratorClassCount=2 \
          -DgeneratorMethodCount=2 \
          test -i

