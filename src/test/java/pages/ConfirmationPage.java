package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends BasePage {
    @FindBy(xpath = "//span[@class='title']")
    public WebElement labelCheckoutTitle;
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public WebElement labelItemName;
    @FindBy(xpath = "//button[@id='finish']")
    public WebElement buttonFinish;

    public String getConfirmationPageTitle() {
        return labelCheckoutTitle.getText();
    }

    public String getConfirmationPageItemName() {
        return labelItemName.getText();
    }

    public void clickFinishButton() {
        buttonFinish.click();
    }
}
