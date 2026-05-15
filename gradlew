#!/bin/sh
##############################################################################
# Gradle wrapper - ARM64 compatible
##############################################################################

APP_HOME="$(cd "$(dirname "$0")" && pwd)"
WRAPPER_JAR="$APP_HOME/gradle/wrapper/gradle-wrapper.jar"

# Java
if [ -n "$JAVA_HOME" ] && [ -x "$JAVA_HOME/bin/java" ]; then
    JAVACMD="$JAVA_HOME/bin/java"
else
    JAVACMD="java"
fi

# Check java
if ! command -v "$JAVACMD" >/dev/null 2>&1; then
    echo "ERROR: JAVA_HOME is not set and java not found in PATH"
    exit 1
fi

exec "$JAVACMD" \
    -classpath "$WRAPPER_JAR" \
    "-Dgradle.user.home=${GRADLE_USER_HOME:-$HOME/.gradle}" \
    "-Dorg.gradle.appname=gradlew" \
    org.gradle.wrapper.GradleWrapperMain "$@"
