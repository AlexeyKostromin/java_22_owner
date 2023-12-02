package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:testing.properties"
})

public interface WebConfigLocal extends Config {
    @Key("local.browser")
    @DefaultValue("chrome")
    String browser();

    @Key("local.browserSize")
    @DefaultValue("1920x1280")
    String browserSize();

    @Key("local.baseUrl")
    @DefaultValue("https://demoqa.com")
    String baseUrl();

}

