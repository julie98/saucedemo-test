package constants;

import utils.ApplicationProperties;

public enum URL {
    Login(""),
    Home("inventory.html"),
    Cart("cart.html"),
    Information("checkout-step-one.html"),
    Checkout("checkout-step-two.html");

    private final String url;
    URL(String path) {
        this.url = ApplicationProperties.get("baseUrl") + path;
    }

    @Override
    public String toString() {
        return url;
    }
}
