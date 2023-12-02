package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.WebConfig;
import helpers.AttachHelper;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {
    private static String remoteUserName = "user1";
    private static String remoteUserPassword = "1234";

    @BeforeAll
    static void beforeAll() {
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

        Configuration.holdBrowserOpen = false;
        Configuration.browser = config.browser();
        Configuration.browserSize = config.browserSize();
        Configuration.baseUrl = config.baseUrl();

        if (config.isRemote()) {
            Configuration.browserVersion = config.browserVersion();
            String remoteDriverUrl = config.remoteUrl();

            Configuration.remote = "https://" + remoteUserName + ":" + remoteUserPassword + "@" + remoteDriverUrl + "/wd/hub";

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }

    @AfterEach
    void addAttachments() {
        AttachHelper.takeScreenshotAs("Last screenshot");
        AttachHelper.pageSource();
        if (!Configuration.browser.equalsIgnoreCase("firefox")) {
            AttachHelper.browserConsoleLogs();
        }
        AttachHelper.addVideo();
        Selenide.closeWebDriver();
    }
}

