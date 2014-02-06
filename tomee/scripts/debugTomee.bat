@echo off
FOR /F "tokens=1,2 delims==" %%G IN (env.properties) DO (set %%G=%%H)
cd %tomeeInstallDir%
call mvn tomee:debug
pause