# HumanReadableBytes
[![Build](https://github.com/emilymclean/HumanReadableBytes/actions/workflows/build.yml/badge.svg)](https://github.com/emilymclean/HumanReadableBytes/actions/workflows/build.yml)
[![Lint](https://github.com/emilymclean/HumanReadableBytes/actions/workflows/lint.yml/badge.svg)](https://github.com/emilymclean/HumanReadableBytes/actions/workflows/lint.yml)
[![Test](https://github.com/emilymclean/HumanReadableBytes/actions/workflows/test.yml/badge.svg)](https://github.com/emilymclean/HumanReadableBytes/actions/workflows/test.yml)

A library providing the famous ["human readable bytes" StackOverflow answer](https://stackoverflow.com/questions/3758606/how-can-i-convert-byte-size-into-a-human-readable-format-in-java).

## Installation
![Stable](https://img.shields.io/github/v/release/emilymclean/HumanReadableBytes?label=Stable)
![Preview](https://img.shields.io/github/v/release/emilymclean/HumanReadableBytes?label=Preview&include_prereleases)

```
implementation "cl.emilym:bytes:<latest>"
```

## Usage
```java

long fileSize = 10_000;
// Prints "The size of the file is 10kB"
System.out.println("The size of the file is " + HumanReadableBytes.si(fileSize));
// Prints "The size of the file is 9.8KiB"
System.out.println("The size of the file is " + HumanReadableBytes.bi(fileSize));

```