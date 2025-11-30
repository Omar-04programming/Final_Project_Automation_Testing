# 🧪 Automation Testing Project

## 🔍 Overview  
This project is an automated testing framework designed to validate "Swag Labs" using Selenium WebDriver with Java. It follows the Page Object Model (POM) design pattern for better maintainability and scalability.

---

## ✨ Key Features  
- **Page Object Model**: clean separation between test logic and page-specific code  
- **Cross-Browser Testing**: supports Chrome and Edge  
- **TestNG Integration**: for test execution and reporting  
- **Logging**: integrated logging for better test execution tracking  
- **Utility Layer**: reusable actions and validations  
- **JSON Data Handling**: dynamic test data loading via `JavaUtils`

---

## 🛠 Technologies Used  
- Java 8+  
- Selenium WebDriver  
- TestNG  
- Maven  
- WebDriverManager  
- JSON for test data  

---

## 📁 Project Structure  
Automation-Testing-Project/ 

<img width="4096" height="753" alt="pages_diagram" src="https://github.com/user-attachments/assets/283789cc-1a60-41a4-982f-57189a3aaed7" />


---

## 📄 UML Class Diagram  
The framework is structured into three main layers:

### 📄 Pages (`pages/`)
Each page class encapsulates:
- WebDriver instance  
- Locators (`By`)  
- Page-specific actions like:
  - `loginToApplication()`  
  - `navigateToCartPage()`  
  - `enterCheckoutDetails()`  
  - `finishCheckout()`  
  - `getHeadingText()`  

### 🧰 Utilities (`utils/`)
Reusable helper classes:
- `BrowserActions`: `navigateToURL()`, `click()`, `getText()`  
- `ElementActions`: `setText()`, `clickElement()`, `getElementText()`  
- `Validations`: `validatePageTitle()`, `validateText()`, `validateTransaction()`  
- `CustomWaitActions`: `waitForElementToBeVisible()`  
- `JavaUtils`: `readJsonFile()`, `getJsonObject()`  
- `DriverManager`: `getDriver()`  

### 🧪 Tests (`tests/`)
Test classes follow modular structure:
- `LoginTest`: `loginWithValidCredentials()`  
- `HomePageTest`: `addItemsToCartAndNavigateToCartPage()`  
- `CartPageTest`: `navigateFromCartToCheckoutPage()`  
- `CheckoutPageTest`: `enterDetailsAndCheckout()`  
- `OverviewPageTest`: `checkOverviewPageDetails()`  
- `BaseTest`: `setUp()`, `tearDown()`, uses `JavaUtils`

---

## ⚙️ Setup Instructions  

### 📌 Prerequisites  
- Java JDK 8 or higher  
- Maven 3.6.0 or higher  
- Chrome/Edge browsers installed  

### 📥 Installation  
```bash
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
- Modular test structure with BaseTest
📄 Presentation
https://www.canva.com/design/DAG6L6Xwkyo/s0EUT_b5hVZNnW3MwKG_JA/edit?utm_content=DAG6L6Xwkyo&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton

