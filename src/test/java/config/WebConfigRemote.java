package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:testing.properties"
})

public interface WebConfigRemote extends Config {
    @Key("remote.browser")
    @DefaultValue("chrome")
    String browser();

    @Key("remote.browserVersion")
    String browserVersion();

    @Key("remote.browserSize")
    @DefaultValue("1920x1280")
    String browserSize();

    @Key("remote.baseUrl")
    @DefaultValue("https://demoqa.com")
    String baseUrl();

    @Key("remote.remoteUrl")
    String remoteUrl();

    @Key("remote.UserName")
    String remoteUserName();

    @Key("remote.UserPassword")
    String remoteUserPassword();
}

