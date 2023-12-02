package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.WebConfigLocal;
import config.WebConfigRemote;
import helpers.AttachHelper;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        var configLocal = ConfigFactory.create(WebConfigLocal.class, System.getProperties());

        Configuration.holdBrowserOpen = false;
        Configuration.browser = configLocal.browser();
        Configuration.browserSize = configLocal.browserSize();
        Configuration.baseUrl = configLocal.baseUrl();

        var isRemote = Boolean.parseBoolean(System.getProperty("isRemote", "false"));
        if (isRemote) {
            var configRemote = ConfigFactory.create(WebConfigRemote.class, System.getProperties());

            Configuration.browser = configRemote.browser();
            Configuration.browserSize = configRemote.browserSize();
            Configuration.baseUrl = configRemote.baseUrl();

            Configuration.browserVersion = configRemote.browserVersion();
            String remoteDriverUrl = configRemote.remoteUrl();
            String remoteUserName = configRemote.remoteUserName();
            String remoteUserPassword = configRemote.remoteUserPassword();

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

