package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {
    private static String remoteUserName = "user1";
    private static String remoteUserPassword = "1234";

    @BeforeAll
    static void beforeAll() {

        Configuration.holdBrowserOpen = false;

        String browser = System.getProperty("browser");
        String browserVersion = System.getProperty("browserVersion");
        String browserSize = System.getProperty("browserSize");
        String remoteDriverUrl = System.getProperty("remoteDriverUrl");

        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.browserSize = browserSize;
        Configuration.baseUrl = "https://demoqa.com";

        //Configuration.browserSize = "1920x1280";
        //Configuration.pageLoadStrategy="eager";
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        Configuration.remote = String.format(
                "https://" +
                "%s:%s" +
                "@%s" +
                "/wd/hub",
                remoteUserName, remoteUserPassword, remoteDriverUrl);

        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", Map.<String, Object> of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));

        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

//        clearBrowserCookies();
//        clearBrowserLocalStorage();
//        sessionStorage().clear();
    }
}

