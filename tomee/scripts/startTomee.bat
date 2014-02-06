@echo off
FOR /F "tokens=1,2 delims==" %%G IN (env.properties) DO (set %%G=%%H)
cd %tomeeInstallDir%
cd %tomeeInstallDir%\target\apache-tomee\bin
call catalina.bat start
pause