$currentLocation = Get-Location
Set-Location ..\..\sl-synth-app

.\gradlew.bat clean test -i

Set-Location $currentLocation
