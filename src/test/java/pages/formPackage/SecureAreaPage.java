package pages.formPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    WebDriver driver;
    By actualMessageBy = By.id("flash");
    By actualTitleBy = By.tagName("h2");
    By logoutButtonBy = By.xpath("//a[@class=\"button secondary radius\"]");
    By loggedInUserBy = By.id("username");
    String expectSuccessMessage = "You logged into a secure area!";
    String expectTitleOfPage = "Secure Area";

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getExpectSuccessMessage() {
        return expectSuccessMessage;
    }

    public String getActualSuccessMessage() {
        return driver.findElement(actualMessageBy).getText();
//        return actualSuccessMessageLocator.getText();
    }

    public String getExpectTitleOfPage() {
        return expectTitleOfPage;
    }

    public String getActualTitleOfPage() {
        return driver.findElement(actualTitleBy).getText();
//        return actualTitleOfPageLocator.getText();
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButtonBy).click();
//        logoutButtonLocator.click();
    }

    public String getActualLoggedInUser() {
        return driver.findElement(loggedInUserBy).getText();
//        return loggedInUserLocator.getText();
    }

}
