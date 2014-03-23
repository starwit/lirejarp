@echo off
echo %cd%
set scriptLocation=%cd%
FOR /F "tokens=1,2 delims==" %%G IN (env.properties) DO (set %%G=%%H)
echo Project Dir: %projectDir% , Application: %applicationName%
cd %projectDir%\%applicationName%
call mvn clean install -DskipTests
cd %scriptLocation%
call redeployApplication.bat
REM pause