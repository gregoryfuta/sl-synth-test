$currentLocation = Get-Location
Set-Location ..\..

.\gradlew.bat clean :sl-code-gen:test --tests 'io.sealights.codegen.*' -DgeneratorPackageName="i0.sealights.webperf.warapp" `
          -DgeneratorTestPackageName="i00test.sealights.synth.test" `
          -DgeneratorModuleCount=32 `
          -DgeneratorClassCount=32 `
          -DgeneratorMethodCount=32 `
          -i

Set-Location $currentLocation
