package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    public WebElement buttonAddToCart;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement iconCart;

    public void clickAddToCartButton() {
        buttonAddToCart.click();
    }

    public void clickCartIcon() {
        iconCart.click();
    }
}
