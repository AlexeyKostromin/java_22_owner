package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1280";
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.pageLoadStrategy="eager";

//        clearBrowserCookies();
//        clearBrowserLocalStorage();
//        sessionStorage().clear();
    }
}

