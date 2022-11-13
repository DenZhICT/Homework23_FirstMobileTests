package browserstack.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class MobileDriverProvider implements WebDriverProvider {

    MobileDriverConfig config = ConfigFactory.create(MobileDriverConfig.class, System.getProperties());

    @SneakyThrows
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("browserstack.user", config.getBrowserstackUser());
        mutableCapabilities.setCapability("browserstack.key", config.getBrowserstackKey());

        mutableCapabilities.setCapability("app", config.getApp());

        mutableCapabilities.setCapability("device", config.getDevice());
        mutableCapabilities.setCapability("os_version", config.getOsVersion());

        mutableCapabilities.setCapability("project", config.getProject());
        mutableCapabilities.setCapability("build", config.getBuild());
        mutableCapabilities.setCapability("name", config.getName());


        return new RemoteWebDriver(new URL(config.getRemoteUrl()), mutableCapabilities);
    }

    public void setMobileDriverConfiguration() {
        Configuration.browser = MobileDriverProvider.class.getName();

        Configuration.browserSize = config.getBrowserSize();
    }
}
