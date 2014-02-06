@echo off
FOR /F "tokens=1,2 delims==" %%G IN (env.properties) DO (set %%G=%%H)
echo Project Dir: %projectDir% , Application: %applicationName%
cd %projectDir%\%applicationName%
call mvn clean install
pause