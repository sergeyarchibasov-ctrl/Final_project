package hooks;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hooks {

    @Before
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\WebDriver\\chrome\\chromedriver.exe"
        );

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}