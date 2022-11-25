# CS2800 Calculator Project

## Summary
An calculator GUI and/or ASCII which can evaluate postfix and infix expressions.

Postfix are expressions where operators appear after the operand. <br>
Infix expressions are what we say everyday, where operator appears between operands.
<pre>POSTFIX: 10 5 + = 15
INFIX:   10 + 5 = 15
</pre>

## Configuration
This programme has been tested on **window** and **linux** machines, unfortunately it has currently not been tested an apple machine.<br>
Tested with java versions **8, 9, 10, 11**.
<br>
By default the application will run in java version 11.
You can change this by opeing the [pom file](./calculator/pom.xml) then changing these lines to a different version:
<br>
```java
<maven.compiler.source>11</maven.compiler.source>
<maven.compiler.target>11</maven.compiler.target>
```
The **javaFX API used in development had version 19**, so javafx runtime also uses version 19 stated in [pom file](./calculator/pom.xml) like below:
```java
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
    <version>19</version>
</dependency>
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-fxml</artifactId>
    <version>19</version>
</dependency>
```
However, although javaFX API used in development was version 19, javafx runtime versions can be changed to **11 to 18** and still works, although there will be a warning message!
