#!/bin/bash

cd ../../sl-code-gen || exit 101

./gradlew -DgeneratorPackageName="i0.sealights.synth.app" \
          -DgeneratorTestPackageName="i00test.sealights.synth.test" \
          -DgeneratorModuleCount=2 \
          -DgeneratorClassCount=2 \
          -DgeneratorMethodCount=2 \
          test -i

