package runners;

import base.CapabilityFactory;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@Test
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        plugin = {"html:target/cucumber-html-report",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class Runner extends AbstractTestNGCucumberTests{
    private String gridURL="http://localhost:4444/wd/hub";       //selenium grid url
    public static String url;

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public CapabilityFactory capabilityFactory = new CapabilityFactory();

    @BeforeMethod(alwaysRun = true)
    @Parameters(value={"browser","env"})
    public void setUp (String browser,String env) throws MalformedURLException {
        driver.set(new RemoteWebDriver(new URL(gridURL), capabilityFactory.getCapabilities(browser)));
        url = setUrl(env);
    }

    //method to get driver from ThreadLocalMap
    public RemoteWebDriver getThreadDriver() {
        return driver.get();
    }

    //to run in parallel
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        getThreadDriver().quit();    //remove the ThreadLocalMap element
    }


    //method to set url for different environments
    private String setUrl(String env) {
        String url = "";
        switch (env){
            case "prod":
                url = "https://www.n11.com/";
                break;
            default:
                break;
        }
        return url;
    }
}
