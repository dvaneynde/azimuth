# Azimuth calculation

## Prerequisites

```
mbp2020:azimuth dirk$ sbt --version
[info] 1.2.8
sbt script version: 1.5.5
```

Version of scala was 2.12.7

## Run tests

```bash
sbt test
```

## Build jar and install into maven repository

```bash
sbt package
```

This will generate `target/scala-2.12/domoticscala_2.12-0.1.0-SNAPSHOT.jar`.

To install it in local repository (**TODO untested**):

```bash
$ mvn install:install-file \
-Dfile=target/scala-2.12/domoticscala_2.12-0.1.0-SNAPSHOT.jar \
-DgroupId="default" \
-DartifactId="domotic-scala_2.12" \
-Dversion="0.1.0-SNAPSHOT" \
-DgeneratePom=true \
-Dpackaging=jar
```

## Integrate this library in a Java program
``` xml
<dependency>
	<groupId>default</groupId>
	<artifactId>domotic-scala_2.12</artifactId>
	<version>1.0</version>
</dependency>
```