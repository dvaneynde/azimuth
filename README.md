# Azimuth calculation

> Note: git log shows too many entries, repository was once an everything-combined repo, which was not a good idea.


## Prerequisites

Use SDKMAN. Then check following:

```
# execute March 10, 2026 
dirk@mmiM1 azimuth % sdk current java
Current default java version 8.0.482-zulu
dirk@mmiM1 azimuth % sdk current sbt 
Current default sbt version 1.12.5
```

Version of scala was 2.12.7, as specified in `sbt` build file. And after first run the version actually used of `sbt` is 1.2.8, check logs.

## Run tests

```bash
sbt test
```

## Build jar and install into local Maven repository

```bash
sbt publishM2
```

This will generate and install `azimuth_2.12-0.1.0.jar` into `~/.m2/repository/eu/dlvm/azimuth_2.12/0.1.0/`.


## Iterative development
For iterative development, use a snapshot version (`0.1.0-SNAPSHOT` in `build.sbt`) — snapshots are always overwritten without needing to manually delete the old artifact:

```bash
sbt publishM2
```

To start clean before publishing:
```bash
rm -rf ~/.m2/repository/eu/dlvm/azimuth_2.12/0.1.0
sbt publishM2
```

## Integrate this library in a Maven project
``` xml
<dependency>
    <groupId>eu.dlvm</groupId>
    <artifactId>azimuth_2.12</artifactId>
    <version>0.1.0</version>
</dependency>
```