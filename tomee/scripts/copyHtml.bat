@echo off
FOR /F "tokens=1,2 delims==" %%G IN (env.properties) DO (set %%G=%%H)
echo copy dir from %webApp% to %tomeeWebappDir%
xcopy %projectDir%\%applicationName%\%webApp% %tomeeWebappDir%\%applicationName% /S/E
pause