package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InformationPage extends BasePage {
    @FindBy(xpath = "//span[@class='title']")
    public WebElement labelInformationTitle;
    @FindBy(xpath = "//input[@id='first-name']")
    public WebElement inputFirstName;
    @FindBy(xpath = "//input[@id='last-name']")
    public WebElement inputLastName;
    @FindBy(xpath = "//input[@id='postal-code']")
    public WebElement inputZipCode;
    @FindBy(xpath = "//input[@id='continue']")
    public WebElement buttonContinue;

    public String getInformationPageTitleText() {
        return labelInformationTitle.getText();
    }

    public void enterFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        inputLastName.sendKeys(lastName);
    }

    public void enterZipCode(String zipCode) {
        inputZipCode.sendKeys(zipCode);
    }

    public void clickContinueButton() {
        buttonContinue.click();
    }
}
