@echo off
FOR /F "tokens=1,2 delims==" %%G IN (env.properties) DO (set %%G=%%H)
echo delete %tomeeWebappDir%\%applicationName% and %tomeeWebappDir%\%warName%
rmdir /s /q %tomeeWebappDir%\%applicationName%
del /F/Q %tomeeWebappDir%\%warName%
echo copy %projectDir%\%applicationName%\%warDir%\%warName% to %tomeeWebappDir%\
copy %projectDir%\%applicationName%\%warDir%\%warName% %tomeeWebappDir%
REM pause