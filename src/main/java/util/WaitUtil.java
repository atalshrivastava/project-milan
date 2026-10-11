package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.WebTestBase;

import java.time.Duration;
import java.util.List;

import static helper.WaitConstant.EXPLICIT_WAIT;

public class WaitUtil extends WebTestBase {
    public static WebDriverWait wait;
    public  static void WaitUntilElementToBeClick(WebElement element)
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }
    public static void WaitUntilElementToBeClickElement(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        // wait.until(ExpectedConditions.elementToBeClickable(elements)).click();

        for (WebElement element : elements) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }
    }
}
