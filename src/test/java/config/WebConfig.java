package config;

import org.aeonbits.owner.Config;

public interface WebConfig extends Config {
    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

//    @Key("browser")
//    @DefaultValue("100.0")
//    String getBrowserVersion();

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com")
    String getBaseUrl();

    @Key("remoteUrl")
    @DefaultValue("")
    String getRemoteUrl();
}
