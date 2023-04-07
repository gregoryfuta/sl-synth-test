$currentLocation = Get-Location
Set-Location ..\..

.\gradlew.bat :sl-code-gen:test -DgeneratorPackageName="i0.sealights.synth.app" `
          -DgeneratorModuleCount=2 `
          -DgeneratorClassCount=2 `
          -DgeneratorMethodCount=2 `
          clean test -i

Set-Location $currentLocation
