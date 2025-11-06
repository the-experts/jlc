# Jira Lightweight CLI (JLC)

[![License: Apache 2.0](https://img.shields.io/badge/License-Apache2-green.svg)](LICENSE)
[![Release](https://img.shields.io/github/v/release/the-experts/jlc?display_name=tag)](https://github.com/boonen/jetta/releases)

JLC is a nifty, tiny tool to retrieve data from Jira in a format that is useful when working in a shell.

## Features

* Secure handling of login credentials
* Fetch projects
* Fetch epics per project
* Fetch user stories per epic
* Output in JSON or CSV format

## Usage

After compilation you can run JLC from the command line. Here are some example commands:

```shell
./target/jlc --help
```

## Development

### Prerequisites

Requirements:
* Java 25
* Maven 3.9 or higher
* GraalVM JDK25

### Build from source
```bash
# CI-friendly version defaults:
#   revision=0.1.0, changelist=-SNAPSHOT
mvn -B -U verify
```

To build a release locally using CI-friendly versions:
```bash
mvn -B -Drevision=1.0 -Dchangelist= package
```

## Contributing

Issues and Pull Requests are welcome.
*	Issues: Please use the templates (bug report / feature request) and provide minimal reproduction where possible.
*	Pull Requests: Keep changes focused. Include tests where applicable. Follow conventional commit messages if you can (e.g. feat: ..., fix: ...).

*By contributing, you agree that your contributions are MIT-licensed.*

