package constants;

import utils.ApplicationProperties;

public enum URL {
    Login(""),
    Inventory("inventory.html"),
    Cart("cart.html"),
    Information("checkout-step-one.html"),
    Confirmation("checkout-step-two.html"),
    Complete("checkout-complete.html");

    private final String url;
    URL(String path) {
        this.url = ApplicationProperties.get("baseUrl") + path;
    }

    @Override
    public String toString() {
        return url;
    }
}
