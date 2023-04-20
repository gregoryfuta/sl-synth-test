$currentLocation = Get-Location
Set-Location ..\..

.\gradlew.bat clean :sl-code-gen:test --tests 'io.sealights.codegen.*' -DgeneratorPackageName="i0.sealights.synth.app" `
          -DgeneratorTestPackageName="i00test.sealights.synth.test" `
          -DgeneratorModuleCount=20 `
          -DgeneratorClassCount=20 `
          -DgeneratorMethodCount=20 `
          -i

Set-Location $currentLocation
