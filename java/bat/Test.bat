@echo off
cd ..
javac -cp "src;lib;bin" src\crud\connection\Test.java -d bin & java -cp "bin;lib/mysql-connector-java-5.1.23-bin.jar" connection.Test & pause