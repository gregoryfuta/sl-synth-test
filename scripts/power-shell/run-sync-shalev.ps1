param([string]$anonymousExecution = 'false', [string]$ccmv = 'v1')

$currentLocation = Get-Location
Set-Location ..\..

docker run -d --name backend -p 9900:9900 534369319675.dkr.ecr.us-west-2.amazonaws.com/sl-tools-mockserver:latest

.\gradlew.bat :sl-synth-app:clean :sl-synth-app:test -i `
    --tests 'i00test.sealights.synth.test.predefined.Synchronous*' `
    "-DcodeCoverageManagerVersion=$ccmv" "-DanonymousExecution=$anonymousExecution" `
    -DenableSlPlugin -DtestRunId=1000m_noSL_sync

Set-Location $currentLocation
