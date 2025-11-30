🧪 Automation Testing Project
🔍 Overview
This project is an automated testing framework designed to validate "Swag Labs" using
Selenium WebDriver with Java. It follows the Page Object Model (POM) design pattern for better
maintainability and scalability.


✨ Key Features
- Page Object Model: clean separation between test logic and page-specific code
- Cross-Browser Testing: supports Chrome and Edge
- TestNG Integration: for test execution and reporting
- Logging: integrated logging for better test execution tracking
- Utility Layer: reusable actions and validations
- JSON Data Handling: dynamic test data loading via JavaUtils

🛠 Technologies Used
- Java 8+
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- JSON for test data

📁 Project Structure

Automation-Testing-Project/

├── pom.xml

├── README.md

├── src/

│   ├── main/java/

│   │   └── pages/ 
 # Page classes (LoginPage, HomePage, etc.)
│   │   └── utils/ 
# Utility classes (BrowserActions, Validations, etc.)
│   ├── test/java/

│   │   └── tests/  
# Test classes (LoginTest, CheckoutPageTest, etc.)
│   ├── test/resources/

│   │   └── testdata/  
# JSON test data files
│   │   └── config.properties
# Configuration
└── testng.xml             # TestNG suite file



🧭 UML Class Diagram
The framework is structured into three main layers:
📄 Pages (pages/)
Each page class encapsulates:
- WebDriver instance
- Locators (By)
- Page-specific actions (e.g. loginToApplication, navigateToCartPage)
- Common method: getHeadingText()
🧰 Utilities (utils/)
Reusable helper classes:
- BrowserActions: click, navigate, getText
- ElementActions: setText, clickElement
- Validations: validate title, text, transaction
- CustomWaitActions: explicit waits
- JavaUtils: JSON parsing and reading
- DriverManager: WebDriver lifecycle
🧪 Tests (tests/)
Test classes follow modular structure:
- LoginTest: login scenarios
- HomePageTest: add items and navigate
- CartPageTest: cart to checkout
- CheckoutPageTest: fill details
- OverviewPageTest: verify summary
- BaseTest: setup/teardown, data loading

⚙️ Setup Instructions
📌 Prerequisites
- Java JDK 8 or higher
- Maven 3.6.0 or higher
- Chrome/Edge browsers installed
📥 Installation
git clone https://github.com/your-username/your-repo-name.git
cd Automation-Testing-Project
mvn clean install



🚀 Running Tests
To run all tests:
mvn test


To run a specific suite:
mvn test -Dsurefire.suiteXmlFiles=testng.xml



🛠 Configuration
Edit src/test/resources/config.properties to configure:
- Browser type (chrome/edge)
- Base URL
- Timeout settings
- Other environment-specific parameters

✅ Best Practices Followed
- Page Object Model for maintainable code
- Explicit waits instead of thread sleep
- Utility classes for common functions
- Logging mechanism
- WebDriverManager for driver setup
- JSON-based dynamic test data
- Consistent naming conventions
- Modular test structure with BaseTest inheritance

📄 Presentation
https://www.canva.com/design/DAG6L6Xwkyo/s0EUT_b5hVZNnW3MwKG_JA/edit?utm_content=DAG6L6Xwkyo&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton

