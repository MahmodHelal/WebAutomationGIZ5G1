package tests;

import baseTest.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormAuthenticationTest extends BaseTests {


    @Test
    public void validLoginTest() {
        formAuthPage = heroHomePage.navigateToFormAuthenticationPage(); //new FormAuthPage(driver);
        formAuthPage.enterUsername("tomsmith");
        formAuthPage.enterPassword("SuperSecretPassword!");
        secureAreaPage = formAuthPage.clickLoginButton(); // new SecureAreaPage(driver);
        Assert.assertTrue(secureAreaPage.getActualTitleOfPage().contains(secureAreaPage.getExpectTitleOfPage()));
        Assert.assertTrue(secureAreaPage.getActualSuccessMessage().contains(secureAreaPage.getExpectSuccessMessage()));
        Assert.assertTrue(driver.getCurrentUrl().contains("/secure"));
        Assert.assertTrue(secureAreaPage.getActualLoggedInUser().contains("tomsmith"));
        // open form auth page
        // enter valid credentials
        // click login
        // validates success message is displayed
    }

    @Test
    public void invalidLoginTestUsername() {
        formAuthPage = heroHomePage.navigateToFormAuthenticationPage(); //new FormAuthPage(driver);

        // open form auth page
        // enter invalid username
        // enter valid password
        // click login
        // validates appropriate error message is displayed
    }

    @Test
    public void invalidLoginTestPassword() {
        heroHomePage.navigateToFormAuthenticationPage();

        // open form auth page
        // enter valid username
        // enter invalid password
        // click login
        // validates appropriate error message is displayed
    }

}
