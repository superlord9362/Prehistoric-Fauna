Param(
    [switch]$Init,
    [switch]$Deploy
);

Function Clean-ForgeBuild([string]$BuildLocation) {
    If (Test-Path $BuildLocation) {
        Remove-Item $BuildLocation
    }
}

# Enable this if needed / if you have different jdks
# $Env:JAVA_HOME = "C:\Program Files\Java\jdk1.8.0_73";

$Output = [Environment]::NewLine + "JAVA_HOME set to: ${Env:JAVA_HOME}" + [Environment]::NewLine
Write-Host $Output -ForegroundColor Green

$ModVersion = "0.1.1";
$MinecraftVersion = "1.12.2";
$PreFaunaBuildLocation = "${PSScriptRoot}";

# Assume things are in a successful state until a failure is detected
$BuildSuccess = $True;

If ($Init) {
    Set-Location $PreFaunaBuildLocation
    $InitProcess = Start-Process -PassThru -NoNewWindow .\gradlew setupDecompWorkspace
    $InitProcess.WaitForExit()
    $InitProcess = Start-Process -PassThru -NoNewWindow .\gradlew eclipse
    $InitProcess.WaitForExit()
    Set-Location ".."

    Write-Host "Finished Init" -ForegroundColor Green
} Else {
    Clean-ForgeBuild "${PreFaunaBuildLocation}\build\libs\prehistoricfauna-${ModVersion}.jar"
    Set-Location -Path $PreFaunaBuildLocation
    $BuildPreFauna = Start-Process -PassThru -NoNewWindow .\gradlew build
    Set-Location -Path ".."

    $BuildPreFauna.WaitForExit();

    If (-Not (Test-Path "${PreFaunaBuildLocation}\build\libs\prehistoricfauna-${ModVersion}.jar")) {
        Write-Host "ERROR: ${PreFaunaBuildLocation} was not built!" -ForegroundColor Red
        $BuildSuccess = $False
    }

    If ($BuildSuccess) {
        If ($Deploy) {
            Copy-Item "${PreFaunaBuildLocation}\build\libs\prehistoricfauna-${ModVersion}.jar" "${Env:APPDATA}\.minecraft\mods\prehistoricfauna-${MinecraftVersion}-${ModVersion}.jar"
            Write-Host "Builds Were Deployed!" -ForegroundColor Green
        } Else {
            Copy-Item "${PreFaunaBuildLocation}\build\libs\prehistoricfauna-${ModVersion}.jar" ".\prehistoricfauna-${MinecraftVersion}-${ModVersion}.jar"
        }

        $Output = [Environment]::NewLine + "Builds Completed Successfully" + [Environment]::NewLine
        Write-Host $Output -ForegroundColor Green
    } Else {
        Write-Host "Build(s) Failed." -ForegroundColor Red
    }
}