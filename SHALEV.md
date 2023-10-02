# SHALEV info

## Code generation

1. `cd scripts/power-shell`
2. Execute `.\generate-app-code.ps1` script. It will generate the sample services and test classes
3. You can change values of the parameters:

``` 
   -DgeneratorModuleCount=2 `
   -DgeneratorClassCount=2 `
   -DgeneratorMethodCount=2 `
```

## Execute tests

1. CD to project root dir
2. run `gradlew.bat --no-daemon :sl-synth-app:clean :sl-synth-app:test`