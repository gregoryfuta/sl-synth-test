$currentLocation = Get-Location
Set-Location ..\..

.\gradlew.bat clean :sl-code-gen:test --tests 'io.sealights.codegen.*' `
          -DgeneratorPackageName="i0.sealights.synth.app" `
          -DgeneratorTestPackageName="i00test.sealights.synth.test" `
          -DgeneratorModuleCount=2 `
          -DgeneratorClassCount=2 `
          -DgeneratorMethodCount=2 `
          -i

Set-Location $currentLocation
