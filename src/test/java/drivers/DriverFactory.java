package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ApplicationProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            setupDriver();
        }
        return webDriver.get();
    }

    private static void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--incognito");

        switch (ApplicationProperties.get("browserType").toLowerCase()) {
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                webDriver.set(new FirefoxDriver());
                break;
            }
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                webDriver.set(new ChromeDriver(options));
                break;
            }
            default: {
                System.out.println("Browser type is not supported!");
            }
        }
        webDriver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.get().manage().window().maximize();
    }
    public static void quitDriver() {
        if (webDriver.get() != null) {
            webDriver.get().quit();
            webDriver.remove();
        }
    }
}