# SauceDemo Test Automation

This is an automated UI testing project for [saucedemo.com](https://www.saucedemo.com) using:
- Java
- Selenium WebDriver
- TestNG
- Cucumber
- Maven
## Features

- Login with valid credentials
- Login with invalid credentials
- Add item to cart and checkout

## How to Run Tests

```bash
mvn test
```
Or simply run `TestRunner.java`.
## Notes

- The default browser is set to Chrome.
- After logging in, a "change password" prompt appears on the inventory page, which disrupts the test flow. To prevent this, ChromeOptions were configured to:
    - Enable **incognito mode**
    - Disable Chrome’s **password manager**
- I’m aware that using `Thread.sleep()` is not considered a good practice in automation, but it's included here for visibility and simplicity during demo runs.
