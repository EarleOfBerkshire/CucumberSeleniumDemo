
# Cucumber Selenium Demo

This is a **demo automation project** showcasing end-to-end test scenarios against the [Sauce Demo](https://www.saucedemo.com/) website using **Cucumber**, **Selenium WebDriver**, and **JUnit 5**.

## Project Overview

The project is designed to demonstrate best practices in behavior-driven development (BDD) testing with Cucumber and Selenium WebDriver in Java. It covers key web automation concepts such as:

- Page Object Model (POM) pattern for maintainable UI interactions
- Reusable step definitions
- Test context management
- WebDriver management with ChromeDriver
- Screenshot capture on test failures
- Configuration management via properties file
- Logging via SLF4J

---

## Technologies & Frameworks

- **Java 17**
- **Maven** for build and dependency management
- **Selenium WebDriver** for browser automation
- **Cucumber JVM** for BDD-style test definition and execution
- **JUnit 5** as test runner
- **SLF4J Simple** for logging
- **ChromeDriver** as the default browser driver

---

## Project Structure

```
src/
├── main/
│   ├── java/com/earleofberkshire/
│   │   ├── pages/             # Page Object classes for UI interactions
│   │   ├── utils/             # Utility classes (WebDriver manager, ConfigReader, Screenshot util)
│   │   └── context/           # Test context to manage page objects & driver instance
│
├── test/
│   ├── java/com/earleofberkshire/stepdefinitions/   # Cucumber step definitions & hooks
│   └── resources/
│       ├── features/         # Gherkin feature files describing test scenarios
│       └── config.properties # Configuration file for environment settings
```

---

## Setup Instructions

1. **Clone the repository**

   ```bash
   git clone https://github.com/EarleOfBerkshire/CucumberSeleniumDemo.git
   cd CucumberSeleniumDemo
   ```

2. **Configure the project**

   Update `src/main/resources/config.properties` as needed to set base URLs or other config values.

3. **Run tests**

   Use Maven to run the Cucumber test suite:

   ```bash
   mvn clean test
   ```

   This will execute all feature scenarios against the Sauce Demo website using ChromeDriver.

---

## Key Features

- **Page Objects:** Encapsulate page UI elements and actions.
- **Step Definitions:** Map Gherkin steps to Java code.
- **Hooks:** Setup and teardown WebDriver instances, capture screenshots on failure.
- **Test Context:** Share WebDriver and page object instances across steps.
- **Config Reader:** Centralized configuration loading.
- **Logging:** Integrated SLF4J logging for better traceability.
- **Screenshots:** Automatically capture and attach screenshots on test failure.

---

## Future Enhancements

- Support for multiple browsers via parameterized WebDriver factory.
- Parallel test execution to speed up test runs.
- Integration with CI/CD pipelines (GitHub Actions, Jenkins).
- More detailed reporting (Allure, Cucumber Reports).
- Externalize environment configurations for different test environments.

---

## Contribution

This project is intended as a learning/demo tool. Contributions and suggestions are welcome via pull requests or issues.

---

## License

This project is released under the MIT License.

---

Feel free to ask if you'd like me to customize this further or add sections like badges, screenshots, or detailed scenario examples!
