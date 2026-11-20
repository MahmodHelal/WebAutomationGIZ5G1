package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HeroHomePage;
import pages.formPackage.FormAuthPage;
import pages.formPackage.SecureAreaPage;

public class BaseTests {
    protected WebDriver driver;
    protected HeroHomePage heroHomePage;
    protected FormAuthPage formAuthPage;
    protected SecureAreaPage secureAreaPage;

    @BeforeClass
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        heroHomePage = new HeroHomePage(driver);

    }

    @BeforeMethod
    public void goToHomepage() {
        driver.get("https://the-internet.herokuapp.com/");
        Assert.assertEquals(driver.getTitle(), "The Internet", "Title is not correct");
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/", "URL is not correct");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
