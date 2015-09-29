package galen.poc;

import com.galenframework.testng.GalenTestNgTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

import static java.util.Arrays.asList;

public class AppTest extends GalenTestNgTestBase {

    private final String url = "http://samples.galenframework.com/tutorial1/tutorial1.html";

    @Override
    public WebDriver createDriver(Object[] args) {
        return new FirefoxDriver();
    }

    @Test
    public void welcomePage_shouldLookGood_onDesktopDevice() throws IOException {
        load(url, 640, 480);
        getDriver().manage().window().maximize();
        checkLayout("src/main/resources/example.gspec", asList("desktop"));
    }
}
