# Counting Code Lines

## About

> Counting lines of code in Java source is not quite as simple as it seems.

It is Java console application that implements Counting Code Lines. 

Solution for: http://codekata.com/kata/kata13-counting-code-lines/


## Build

1. For building application, please use following command: 

```bash
./mvnw clean package 
```

2. After execution, there will be `target/code-lines.jar` file.

## Usage

1. Help 

```bash
java -jar target/code-lines.jar
```

2. Count in folder 

```bash
java -jar target/code-lines.jar -f src/main/java/com/karpunets/codelines
```

3. Count file

```bash
java -jar target/code-lines.jar -f src/test/resources/File3Lines.java
```