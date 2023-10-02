param([string]$anonymousExecution = 'false', [string]$ccmv = 'v1')

$currentLocation = Get-Location
Set-Location ..\..

docker run -d --name backend -p 9900:9900 534369319675.dkr.ecr.us-west-2.amazonaws.com/sl-tools-mockserver:latest

#$tokenNotReady = $true
#
#do {
#    Start-Sleep -Seconds 2
#    $TokenResponse = Invoke-WebRequest -URI http://localhost:9900/api/test/token?hostname=localhost
#    if ($TokenResponse.Content.Length -gt 32) {
#        $tokenNotReady = $false
#        Out-File -FilePath .\mock-token.txt -InputObject $TokenResponse.Content -Encoding utf8
#    }
#} While ($tokenNotReady)


.\gradlew.bat :sl-synth-app:clean :sl-synth-app:test -i --tests 'i00test.sealights.synth.test.predefined.Synchronous*' `
    "-DcodeCoverageManagerVersion=$ccmv" "-DanonymousExecution=$anonymousExecution" `
    -DenableSlPlugin -DtestRunId=1000m_noSL_sync

Set-Location $currentLocation

docker stop backend
docker rm backend
