package stepDefinitions;

import constants.URL;
import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginSteps {
    private LoginPage loginPage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        DriverFactory.getDriver().navigate().to(URL.Login.toString());
        loginPage = new LoginPage();
    }

    @When("I enter the username {string}")
    public void i_enter_the_username(String username) {
        loginPage.enterUsername(username);
    }

    @And("I enter the password {string}")
    public void i_enter_the_password(String password) {
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should see {string}")
    public void i_should_see_result(String result) {
        if (result.equals("the product page")) {
            assertEquals(DriverFactory.getDriver().getCurrentUrl(),
                    URL.Home.toString());
        } else if (result.equals("an error message")) {
            assertTrue(loginPage.getErrorMessageText().contains("Epic sadface"), "login error message: " + loginPage.getErrorMessageText());
        } else {
            throw new IllegalArgumentException("Unexpected result: " + result);
        }
    }
}
