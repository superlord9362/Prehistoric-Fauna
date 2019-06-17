Param(
    [switch]$Init,
    [switch]$Deploy,
    [switch]$RunLauncher
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

$PreFaunaVersion = "1.1.1-dev";
$MinecraftVersion = "1.12.2";
$LLibraryVersion = "1.7.19";

$PreFaunaBuildLocation = "${PSScriptRoot}";
$LLibraryBuildLocation = "${PSScriptRoot}/lib/llibrary";

# Assume things are in a successful state until a failure is detected
$BuildSuccess = $True;

If ($Init) {
    # Set-Location $LLibraryBuildLocation
    # $InitProcess = Start-Process -PassThru -NoNewWindow .\gradlew setupDecompWorkspace
    # $InitProcess.WaitForExit()
    # $InitProcess = Start-Process -PassThru -NoNewWindow .\gradlew eclipse
    # $InitProcess.WaitForExit()

    Set-Location $PreFaunaBuildLocation
    $InitProcess = Start-Process -PassThru -NoNewWindow .\gradlew setupDecompWorkspace
    $InitProcess.WaitForExit()
    $InitProcess = Start-Process -PassThru -NoNewWindow .\gradlew eclipse
    $InitProcess.WaitForExit()

    Write-Host "Finished Init" -ForegroundColor Green
} Else {
    # Clean-ForgeBuild "${LLibraryBuildLocation}\build\libs\llibrary.jar"
    # Set-Location -Path $LLibraryBuildLocation
    # $BuildLLibrary = Start-Process -PassThru -NoNewWindow .\gradlew build
    # Set-Location -Path $PreFaunaBuildLocation

    Clean-ForgeBuild "${PreFaunaBuildLocation}\build\libs\prehistoricfauna.jar"
    Set-Location -Path $PreFaunaBuildLocation
    $BuildPreFauna = Start-Process -PassThru -NoNewWindow .\gradlew build

    # $BuildLLibrary.WaitForExit();
    $BuildPreFauna.WaitForExit();

    # If (-Not (Test-Path "${LLibraryBuildLocation}\build\libs\llibrary.jar")) {
    #     Write-Host "ERROR: ${PreFaunaBuildLocation} was not built!" -ForegroundColor Red
    #     $BuildSuccess = $False
    # }

    If (-Not (Test-Path "${PreFaunaBuildLocation}\build\libs\prehistoricfauna.jar")) {
        Write-Host "ERROR: ${PreFaunaBuildLocation} was not built!" -ForegroundColor Red
        $BuildSuccess = $False
    }

    If ($BuildSuccess) {
        If ($Deploy) {
            If (Test-Path "${Env:APPDATA}\.minecraft\mods\prehistoricfauna-${MinecraftVersion}-${PreFaunaVersion}.jar") {
                Remove-Item "${Env:APPDATA}\.minecraft\mods\prehistoricfauna-${MinecraftVersion}-${PreFaunaVersion}.jar";
            }
            Copy-Item "${PreFaunaBuildLocation}\build\libs\prehistoricfauna.jar" "${Env:APPDATA}\.minecraft\mods\prehistoricfauna-${MinecraftVersion}-${PreFaunaVersion}.jar"
            
            If ($RunLauncher) {
                & 'C:\Program Files (x86)\Minecraft\MinecraftLauncher.exe'
            }

            Write-Host "Builds Were Deployed!" -ForegroundColor Green

        } Else {
            Copy-Item "${PreFaunaBuildLocation}\build\libs\prehistoricfauna.jar" ".\prehistoricfauna-${MinecraftVersion}-${PreFaunaVersion}.jar"
        }

        $Output = [Environment]::NewLine + "Builds Completed Successfully" + [Environment]::NewLine
        Write-Host $Output -ForegroundColor Green
    } Else {
        Write-Host "Build(s) Failed." -ForegroundColor Red
    }
}