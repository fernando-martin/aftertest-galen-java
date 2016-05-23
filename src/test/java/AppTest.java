import com.galenframework.testng.GalenTestNgTestBase;
import domain.Device;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Collections;

public class AppTest extends GalenTestNgTestBase {

    @Override
    public WebDriver createDriver(Object[] args) {
        return new FirefoxDriver(DesiredCapabilities.firefox());
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
