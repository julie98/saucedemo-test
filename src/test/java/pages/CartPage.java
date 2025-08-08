package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(xpath = "//span[@class='title']")
    public WebElement labelCheckoutPageTitle;
    @FindBy(xpath = "//button[@id='checkout']")
    public WebElement buttonCheckout;

    public String getCheckoutPageTitleText() {
        return labelCheckoutPageTitle.getText();
    }

    public void clickCheckoutButton() {
        buttonCheckout.click();
    }
}
