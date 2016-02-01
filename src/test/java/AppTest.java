import com.galenframework.testng.GalenTestNgTestBase;
import galen.poc.devices.Device;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

import static java.util.Arrays.asList;

public class AppTest extends GalenTestNgTestBase {

    @Override
    public WebDriver createDriver(Object[] args) {
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            System.err.println("Malformed URL");
            System.exit(-1);
        }
        return driver;
    }

    @DataProvider(name = "devices")
    public Object[][] devices() {
        return new Object[][]{
                {new Device("mobile", new Dimension(640, 960), Collections.singletonList("mobile"))},
                {new Device("tablet", new Dimension(1024, 768), Collections.singletonList("tablet"))},
                {new Device("desktop", new Dimension(1280, 1024), Collections.singletonList("desktop"))}
        };
    }

    @Test(dataProvider = "devices")
    public void exampleTest(Device device) throws IOException {
        String url = "http://samples.galenframework.com/tutorial1/tutorial1.html";

        load(url, device.getSize().getWidth(), device.getSize().getHeight());
        checkLayout("src/main/java/resources/example.gspec", device.getTags());
    }
}
