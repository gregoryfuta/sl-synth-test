param([string]$anonymousExecution = 'false', [string]$ccmv = 'v3')

$currentLocation = Get-Location
Set-Location ..\..


.\gradlew.bat --stop
.\gradlew.bat :sl-synth-app:clean :sl-synth-app:test -i --stacktrace --tests 'gen.i00test.sealights.synth.test.module*' `
    "-DcodeCoverageManagerVersion=$ccmv" "-DanonymousExecution=$anonymousExecution" `
    -DenableSlPlugin -DtestRunId=testGroupId

Set-Location $currentLocation

