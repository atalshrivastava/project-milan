package Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import util.JavaExecutorScriptUtil;
import util.WaitUtil;

public class HomePage extends WebTestBase {


     @FindBy(xpath="//a[text()='Home']")
     WebElement homepage;
     @FindBy(xpath="//span[text()='Contact Us']")
     WebElement contactus;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void ClickOnHomePage() {
        WaitUtil.WaitUntilElementToBeClick(homepage);

    }
    public void JavaScriptMethod() {

        JavaExecutorScriptUtil.scrollAndClick(contactus,driver);

    }



}
