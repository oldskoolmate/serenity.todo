package utils;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class MyChromeDriver implements DriverSource {

    private Logger logger = LoggerFactory.getLogger(MyChromeDriver.class);

    @Override
    public WebDriver newDriver() {
        ChromeDriverManager.getInstance(CHROME).setup();


        ChromeOptions options = new ChromeOptions();
<<<<<<< HEAD
        options.addArguments("--start-fullscreen", "--test-type", "--no-first-run");

=======
        options.addArguments("--start-maximized");
>>>>>>> b5663861b5132351de73c8f046493837ee203dd2
        ChromeDriver chromeDriver = new ChromeDriver(options);

        logger.info("Using ChromeDriver with config -> " + chromeDriver.getCapabilities().toString());
        logger.info("Using ChromeDriver with options -> " + options.asMap());

        return chromeDriver;
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }

}
