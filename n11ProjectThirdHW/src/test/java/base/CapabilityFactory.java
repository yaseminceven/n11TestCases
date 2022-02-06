package base;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

//class to set options for different browsers
public class CapabilityFactory {
    public DesiredCapabilities capabilities = new DesiredCapabilities();
    public DesiredCapabilities getCapabilities (String browser) {
        switch (browser){
            case "MicrosoftEdge":
                capabilities.setCapability(EdgeOptions.CAPABILITY,getEdgeOptions());
                break;
            case "chrome":
                capabilities.setCapability(ChromeOptions.CAPABILITY,getChromeOptions());
                break;
            case "firefox":
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS,getFirefoxOptions());
                break;
            default:
                break;
        }
       return capabilities;
    }

    private EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("headless");
        options.addArguments("start-maximized");
        options.addArguments("inprivate");
        return options;
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("incognito");
        return options;
    }

    private FirefoxOptions getFirefoxOptions() {
        FirefoxProfile profile = new FirefoxProfile();
        FirefoxOptions options = new FirefoxOptions();
        profile.setPreference("browser.privatebrowsing.autostart", true);
        profile.setPreference("network.proxy.type", 0);     //no proxy settings
        options.setHeadless(true);
        options.setProfile(profile);
        return options;
    }
}
