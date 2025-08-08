package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@id='user-name']")
    public WebElement inputUsername;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement inputPassword;
    @FindBy(xpath = "//input[@id='login-button']")
    public WebElement buttonLogin;
    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMessage;

    public void enterUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        buttonLogin.click();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
