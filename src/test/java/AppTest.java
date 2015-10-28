import com.galenframework.testng.GalenTestNgTestBase;
import galen.poc.devices.Device;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static java.util.Arrays.asList;

public class AppTest extends GalenTestNgTestBase {

    private final String url = "http://samples.galenframework.com/tutorial1/tutorial1.html";

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
                {new Device("mobile", 640, 960, asList("mobile"))},
                {new Device("tablet", 1024, 768, asList("tablet"))},
                {new Device("desktop", 1280, 1024, asList("desktop"))}
        };
    }

    @Test(dataProvider = "devices")
    public void exampleTest(Device device) throws IOException {
        load(url, device.getWidth(), device.getHeight());
        checkLayout("src/main/java/resources/example.gspec", device.getTags());
    }
}
