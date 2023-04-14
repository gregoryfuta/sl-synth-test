$currentLocation = Get-Location
Set-Location ..\..

.\gradlew.bat :sl-synth-app:test -i --tests 'gen.i00test.sealights.synth.test.*'

Set-Location $currentLocation
