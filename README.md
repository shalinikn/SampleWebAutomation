# Sample Web Automation Project

UI test automation for the [TodoMVC React app](https://todomvc.com/examples/react/dist/), built with Selenium, TestNG and Maven.

## Tech Stack

| Tool | Version | Purpose |
|---|---|---|
| Java | 17+ | Language |
| Maven | 3.9+ | Build and dependencies |
| Selenium WebDriver | 4.10.0 | Browser automation |
| WebDriverManager | 5.9.2 | Downloads chromedriver automatically |
| TestNG | 7.4.0 | Test framework |
| ExtentReports | 4.0.9 | HTML test report |
| Logback | 1.3.0 | Logging |
| Lombok | 1.18.34 | Removes boilerplate code |

## Architecture

Page Object Model:

```
src/test/
├── testng.xml                  # Test suite
└── java/
    ├── TestClasses/            # Tests
    │   ├── BaseTest            #   opens and closes Chrome
    │   ├── PageObjectManager   #   provides page objects to tests
    │   └── HomePageTest        #   test cases
    ├── PageClasses/            # Page objects
    │   ├── BasePage            #   shared waits and actions
    │   └── HomePage            #   TodoMVC locators and actions
    ├── WebUtils/WebActions     # Hover, drag-and-drop, JS click
    └── utils/                  # Extent report listener
```

Each test calls `HomePage` through `PageObjectManager`. `HomePage` uses the helpers in `BasePage` to drive Chrome.

## What Happens When You Run It

1. Maven downloads the dependencies and compiles the tests.
2. TestNG reads `testng.xml` and starts `HomePageTest`.
3. `BaseTest` downloads the matching chromedriver, opens Chrome and loads the TodoMVC app.
4. The tests run in order on the same browser:
   - open the app
   - add to-dos ("WakeUp", "Gym", "Get Ready")
   - mark one complete
   - view the Active and All tabs
   - clear completed items
   - check the "items left" count
5. The listener logs each pass or fail to the Extent report.
6. Chrome closes and the reports are saved.

## Setup

**Prerequisites:** JDK 17+, Maven, Google Chrome

```bash
git clone https://github.com/shalinikn/SampleWebAutomation.git
cd SampleWebAutomation

# Run tests with the Extent report
mvn test -Dsurefire.suiteXmlFiles=src/test/testng.xml
```

**Reports:** The TestNG report is written to `target/surefire-reports/index.html`, and the Extent report to `reports/index.html`.
