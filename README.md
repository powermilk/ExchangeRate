# ExchangeRate

Application shows minimal and maximal value for exchange rate of GBP against EUR from last 10 days

## Getting Started

First, you need to ensure you have this applications:

- [GIT](https://git-scm.com/) - GIT isn't necessary, but is better to have installed
- IDE (I prefer [Intellij Idea](https://www.jetbrains.com/idea/)) - It isn't necessary, but in IDE you can lookup code quicker and nicer.
- [Maven](https://maven.apache.org/) - necessary to build project, sometimes IDE have internal version of Maven
- [Java JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - This one is mandatory ;)

You can download project in two ways:
 - By GIT, typing in console this command:
 ```
https://github.com/powermilk/ExchangeRate.git
 ```
 If you dicide using this one, I assume you know a basics of GIT
 - By download ZIP file

 You need to just download [this file](https://github.com/powermilk/ExchangeRate/archive/master.zip).

## Prerequisites

You can build this project with [Maven](https://maven.apache.org/), so dependencies are automatically downloaded and imported, but for your information I listed what technologies are used in this repository:

Code:
- [Java 8](https://www.java.com/pl/download/) - If you want to develop this application you will need [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). Java is programming language what I used to write this program. I used version 8 and some features like lambdas, Streams, Comparator and method reference.
- [Logback](https://logback.qos.ch/) - Library for terminal logs.
- [Gson](https://github.com/google/gson) - A serialization or deserialization library to convert Java Objects into JSON and back from Google.

Testing
- [JUnit 5](https://junit.org/junit5) - The testing Framework.

## Running application

This application just presents solution of some issue and it can be run itself. It doesn't have main() method.

## Running the tests

I used in this project Maven Surefire, so you can run test with this command:
```
mvn surefire:test
```
## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/powermilk/edbdf8672cbf27a0fd9f31f7ec14d983) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Rafał Kociniewski** - [PowerMilk](https://github.com/powermilk)

## License

This project is licensed under the MIT License - see the [LICENSE.md](https://gist.github.com/powermilk/9f5c5cc4b1151f5e4e27cd6ae73a5da1) file for details