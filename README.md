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
## Other information
The default browser is set to chrome. <br>
After logging in, a "change password" prompt appears on the inventory page, which disrupts the test flow. To prevent this, I configured ChromeOptions to disable Chrome’s password manager during driver setup.