package stepDefinitions;

import constants.URL;
import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class checkoutSteps {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private InformationPage informationPage;
    private ConfirmationPage confirmationPage;
    private CompletePage completePage;
    private static final String CART_PAGE_TITLE = "Your Cart";
    private static final String INFORMATION_PAGE_TITLE = "Checkout: Your Information";
    private static final String CONFIRMATION_PAGE_TITLE = "Checkout: Overview";
    private static final String CONFIRMATION_PAGE_ITEM_NAME = "Sauce Labs Backpack";
    private static final String COMPLETE_PAGE_THANK_YOU_TEXT = "Thank you for your order!";



    @Given("I am logged in and on the inventory page with {string} and {string}")
    public void i_am_logged_in_add_on_the_inventory_page(String username, String password) throws InterruptedException {
        DriverFactory.getDriver().navigate().to(URL.Login.toString());
        loginPage = new LoginPage();
        loginPage.login(username, password);
        assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("inventory"));
        Thread.sleep(3000);
    }

    @When("I add an item to the cart")
    public void i_add_an_item_to_the_cart() throws InterruptedException {
        inventoryPage = new InventoryPage();
        inventoryPage.clickAddToCartButton();
        Thread.sleep(3000);
    }

    @And("I go to the cart page")
    public void i_go_to_the_cart_page() throws InterruptedException {
        inventoryPage.clickCartIcon();
        cartPage = new CartPage();
        assertEquals(cartPage.getCheckoutPageTitleText(), CART_PAGE_TITLE);
        Thread.sleep(3000);
    }

    @And("I click the checkout button")
    public void i_click_the_checkout_button() {
        cartPage.clickCheckoutButton();
    }

    @Then("I should be directed to the information page")
    public void i_should_be_directed_to_the_information_page() {
        informationPage = new InformationPage();
        assertEquals(informationPage.getInformationPageTitleText(), INFORMATION_PAGE_TITLE);
    }

    @When("I enter the customer information {string} {string} {string}")
    public void i_enter_the_customer_information(String firstName, String lastName, String zipCode) throws InterruptedException {
        informationPage.enterFirstName(firstName);
        informationPage.enterLastName(lastName);
        informationPage.enterZipCode(zipCode);
        Thread.sleep(3000);
    }

    @And("I click the continue button")
    public void i_click_the_continue_button() {
        informationPage.clickContinueButton();
    }

    @Then("I should see the confirmation page")
    public void i_should_see_the_confirmation_page() throws InterruptedException {
        confirmationPage = new ConfirmationPage();
        assertEquals(confirmationPage.getConfirmationPageTitle(), CONFIRMATION_PAGE_TITLE);
        assertEquals(confirmationPage.getConfirmationPageItemName(), CONFIRMATION_PAGE_ITEM_NAME);
        Thread.sleep(3000);
    }

    @And("I click the finish button")
    public void i_click_the_finish_button() throws InterruptedException {
        confirmationPage.clickFinishButton();
        Thread.sleep(3000);
    }

    @Then("I should see the order complete page")
    public void i_should_see_the_order_complete_page() throws InterruptedException {
        completePage = new CompletePage();
        assertEquals(completePage.getCompleteOrderPageText(), COMPLETE_PAGE_THANK_YOU_TEXT);
        completePage.clickBackHomeButton();
        Thread.sleep(3000);
        assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("inventory"));
    }
}
