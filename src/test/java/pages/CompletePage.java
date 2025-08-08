package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompletePage extends BasePage {
    @FindBy(xpath = "//h2[normalize-space()='Thank you for your order!']")
    public WebElement textThankYou;
    @FindBy(xpath = "//button[@id='back-to-products']")
    public WebElement buttonBackHome;

    public String getCompleteOrderPageText() {
        return textThankYou.getText();
    }

    public void clickBackHomeButton() {
        buttonBackHome.click();
    }
}
