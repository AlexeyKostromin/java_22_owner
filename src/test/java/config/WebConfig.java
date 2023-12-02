package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface WebConfig extends Config {
    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserVersion")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1280")
    String browserSize();

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com")
    String baseUrl();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();

    @Key("remoteUrl")
    String remoteUrl();
}

