@echo off
REM Run the HelloWorld main class with correct classpath
setlocal
set ROOT=%~dp0
set CP=%ROOT%dsa\target\classes;%ROOT%target\classes
java -cp "%CP%" com.rpk.HelloWorld
endlocal
