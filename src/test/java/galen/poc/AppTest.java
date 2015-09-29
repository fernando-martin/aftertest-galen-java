package galen.poc;

import com.galenframework.testng.GalenTestNgTestBase;
import galen.poc.devices.Device;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static java.util.Arrays.asList;

public class AppTest extends GalenTestNgTestBase {

    private final String url = "http://samples.galenframework.com/tutorial1/tutorial1.html";

    @Override
    public WebDriver createDriver(Object[] args) {
        WebDriver driver = new FirefoxDriver();
        if (args.length > 0) {
            if (args[0] != null && args[0] instanceof Device) {
                Device device = (Device) args[0];
                driver.manage().window().setSize(device.getScreenSize());
            }
        }
        return driver;
    }

    @DataProvider(name = "devices")
    public Object[][] devices() {
        return new Object[][]{
                {new Device("mobile", new Dimension(1280, 768), asList("mobile"))},
                {new Device("desktop", new Dimension(1024, 800), asList("desktop"))}
        };
    }

    @Test(dataProvider = "devices")
    public void exampleTest(Device device) throws IOException {
        load(url);
        checkLayout("src/main/resources/example.gspec", device.getTags());
    }
}
