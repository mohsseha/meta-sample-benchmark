@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  Gradle startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

@rem Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass any JVM options to this script.
set DEFAULT_JVM_OPTS="-Xmx64m" "-Xms64m"

@rem Find the project's root directory
set "APP_HOME=%~dp0"

@rem Add the jar to the classpath
set "CLASSPATH=%APP_HOME%gradle\wrapper\gradle-wrapper.jar"

@rem Set the default JVM options
if not defined JAVA_OPTS set "JAVA_OPTS=%DEFAULT_JVM_OPTS%"

@rem Find java.exe
if defined JAVA_HOME (
    set "JAVA_EXE=%JAVA_HOME%/bin/java.exe"
) else (
    set "JAVA_EXE=java.exe"
)

@rem Check if java.exe can be found
where %JAVA_EXE% >nul 2>nul
if %errorlevel% neq 0 (
    echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
    echo.
    echo Please set the JAVA_HOME variable in your environment to match the
    echo location of your Java installation.
    goto:eof
)

@rem Execute Gradle
"%JAVA_EXE%" %JAVA_OPTS% -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*
