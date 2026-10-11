package testbase;

import helper.BrowserConstant;
import helper.WaitConstant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class WebTestBase {
    public static WebDriver driver;
    public static Properties prop;

    public WebTestBase() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/properties/config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        prop = new Properties();
        try {
            prop.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initialization() {
        String browsername = prop.getProperty("browser");
        if (browsername.equalsIgnoreCase(BrowserConstant.CHROME)) {
            driver = new ChromeDriver();
        } else if (browsername.equalsIgnoreCase(BrowserConstant.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browsername.equalsIgnoreCase(BrowserConstant.EDGE)) {
            driver = new EdgeDriver();

        } else {
            throw new RuntimeException("please the select correct browser name ");
        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WaitConstant.PAGE_LOAD_TIMEOUT));
        driver.manage().deleteAllCookies();
    }

}
