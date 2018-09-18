## Screenplay

These tests use tasks, questions and page elements defined in `src/main/java/todos/screenplay`

The overall project structure:
````
+ model
    Domain model classes
+ tasks
    Business-level tasks
+ ui
    Page Objects and Page Elements
+ questions
    Objects used to observe the state of the page
````

## Cucumber

A cucumber framework is used to write acceptance tests in BDD style thus functional validation can be easily readable and understandable to Business Analysts, Developers, Testers, etc.
Cucumber sources are defined in `src/test`.<br/>
Cucumber directory structure:

```
+ steps
    Step definitions for the feature files
+ features
    Files where you describe your tests in gherkin
```
## Running the project

To run the project you'll need JDK 1.8.

**Run all tests from command line**

```
gradle test
```

This runs Cucumber features using Cucumber's JUnit runner.
Feature files are located in `src/test/resources/features/`.

**Run only specific scenarios from command line**

By default tag `@all` is being used from `CukesRunner` class. To specify what to run by tag:

```
gradle tests -Dcucumber.options="--tags @clearCompletedTodoItems"
```

**Run from IDEA**

Locate `CukesRunner` class and run it as a JUnit test

## Reporting

**aggregate**

Generates the Serenity aggregate reports from the JSON test results produced when you run the Serenity BDD tests

```
gradle test aggregate
```
This will run the tests and generate an aggregate report in the `target/site/serenity` directory.

## IDEA Plugins

* Gherkin (Provides support of Gherkin language)
* Cucumber for Java (Enables Cucumber support with step definitions written in Java)
