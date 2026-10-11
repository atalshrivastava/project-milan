package testcase;

import Pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testbase.WebTestBase;

public class HomeTest extends WebTestBase {
    public HomePage homepage;

    public HomeTest ()
    {
        super();
    }
    @BeforeMethod
    public void preRequsite() {
        initialization();
        homepage = new HomePage();
    }
    @Test
    public void VerifyCafeFinderMethod()
    {
        homepage.ClickOnHomePage();
        homepage.JavaScriptMethod();




    }
}
