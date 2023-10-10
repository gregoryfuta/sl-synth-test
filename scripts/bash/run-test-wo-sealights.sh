currentLocation=$(pwd)
cd ../..

./gradlew :sl-synth-app:test -i --tests 'gen.i00test.sealights.synth.test.*'

cd $currentLocation