package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;

public class TestBase {
    private static String remoteUserName = "user1";
    private static String remoteUserPassword = "1234";

    @BeforeAll
    static void beforeAll() {

        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

        Configuration.holdBrowserOpen = false;

        String browser = config.getBrowser();
        //String browserVersion = config.getBrowserVersion();;
        //String browserSize = System.getProperty("browserSize", "1920x1280");
        String browserSize = config.getBrowserSize();
        String baseUrl = config.getBaseUrl();
        String remoteDriverUrl = config.getRemoteUrl();


//        String browser = System.getProperty("browser", "chrome");
//        String browserVersion = System.getProperty("browserVersion", "100.0");
//        String browserSize = System.getProperty("browserSize", "1920x1280");
//        String remoteDriverUrl = System.getProperty("remoteDriverUrl");

        Configuration.browser = browser;
        //Configuration.browserVersion = browserVersion;
        Configuration.browserSize = browserSize;
//        Configuration.baseUrl = "https://demoqa.com";
        Configuration.baseUrl = baseUrl;;

        //Configuration.remote = "https://" + remoteUserName + ":" + remoteUserPassword + "@" + remoteDriverUrl + "/wd/hub";

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        capabilities.setCapability("selenoid:options", Map.of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
//
//        Configuration.browserCapabilities = capabilities;

    }
}

