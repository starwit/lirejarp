@echo off
FOR /F "tokens=1,2 delims==" %%G IN (env.properties) DO (set %%G=%%H)
echo delete %webApp%\%tomeeWebappDir% and %webApp%\%tomeeWebappDir%.war
del %tomeeWebappDir%\%applicationName%
del %tomeeWebappDir%\%warName%
echo copy %projectDir%\%applicationName%\%warDir%\%warName% to %tomeeWebappDir%\
copy %projectDir%\%applicationName%\%warDir%\%warName% %tomeeWebappDir%
pause