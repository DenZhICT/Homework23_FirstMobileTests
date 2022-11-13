package browserstack.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/remote.properties",
})
public interface MobileDriverConfig extends Config {

    @Key("browserstack.user")
    String getBrowserstackUser();

    @Key("browserstack.key")
    String getBrowserstackKey();

    @Key("app")
    String getApp();

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getOsVersion();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("browserSize")
    String getBrowserSize();
}