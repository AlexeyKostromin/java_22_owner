package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface WebConfig extends Config {
    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com")
    String getBaseUrl();

    @Key("browserSize")
    @DefaultValue("1920x1280")
    String getBrowserSize();

    @Key("remoteUrl")
    @DefaultValue("https://selenoid.autotests.cloud")
    String getRemoteUrl();
}
