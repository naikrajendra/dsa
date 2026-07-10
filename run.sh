#!/usr/bin/env bash
# Run the HelloWorld main class with correct classpath
DIR="$(cd "$(dirname "$0")" && pwd)"
java -cp "$DIR/dsa/target/classes:$DIR/target/classes" com.rpk.HelloWorld
