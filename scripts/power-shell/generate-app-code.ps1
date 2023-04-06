$currentLocation = Get-Location
Set-Location ..\..\sl-code-gen

.\gradlew.bat -DgeneratorPackageName="i0.sealights.synth.app" `
          -DgeneratorModuleCount=2 `
          -DgeneratorClassCount=2 `
          -DgeneratorMethodCount=2 `
          clean test -i

Set-Location $currentLocation

.\gradlew.bat -DgeneratorPackageName="i0.sealights.synth.app"  -DgeneratorModuleCount=2 -DgeneratorClassCount=2 -DgeneratorMethodCount=2 clean test -i