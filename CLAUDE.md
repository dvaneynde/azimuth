# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Azimuth is a focused Scala library that calculates solar positioning (sun height angle / elevation and azimuth) for use in home automation / domotic systems. It is published to Maven Central as `eu.dlvm:azimuth_2.12:0.1.0`.

The latitude is hardcoded to 52° (Netherlands, Delft area). All solar geometry formulas are based on TU Delft references.

## Build and Test Commands

```bash
sbt test          # Run tests
sbt publishM2     # Build and install jar to local Maven (~/.m2)
```

Use snapshot versions (`0.1.0-SNAPSHOT` in `build.sbt`) during development — snapshots are always overwritten without cleanup.

**Toolchain**: Scala 2.12.7, SBT 1.2.8, Java 8 (zulu). Java version is managed via SDKMAN (see `.sdkmanrc`).

## Architecture

All logic lives in a single singleton object `SunHeightAzimuth` (`src/main/scala/eu/dlvm/domotic/sensor/sun/SunHeightAzimuth.scala`).

**Public API:**
- `azimuth(dag: Int, uur: Double): Double` — horizontal angle of the sun relative to south
- `hoogtehoek(dag: Int, uur: Double): Double` — elevation angle above the horizon

Both take `dag` (day of year, 1–365) and `uur` (hour of day as Double, e.g. 13.5 = 13:30).

**Internal calculation chain:**
1. `calcD(dag)` — declination angle (seasonal variation)
2. `calcU(uur)` — hour angle (daily rotation)
3. `calcH(d, u)` — elevation from declination + hour angle
4. Cosine of latitude is pre-computed at object init for performance

Variable names follow Dutch conventions: `breedtegraad` (latitude), `dag` (day), `uur` (hour), `d` (declination), `u` (hour angle), `h` (height/elevation).

## Tests

`SunHeightAzimuthSpec.scala` uses ScalaTest FlatSpec. The test file embeds reference tables (from TU Delft) for Dec 22, Mar/Sep 21, and Jun 21 as the expected-value specification. Tests are currently incomplete (WIP).

`SunDirection.sc` is a Scala worksheet for interactive exploration — it demonstrates library usage and is not part of the test suite.
