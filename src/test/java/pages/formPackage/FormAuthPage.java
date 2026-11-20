package pages.formPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormAuthPage {
    WebDriver driver;
    String expectErrorMessageUsername = "Your username is invalid!";
    String expectErrorMessagePassword = "Your password is invalid!";
    String expectTitleOfPage = "Login Page";

    public FormAuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WebElement usernameLocator = driver.findElement(By.id("username"));

        usernameLocator.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordLocator = driver.findElement(By.id("password"));

        passwordLocator.sendKeys(password);
    }

    public SecureAreaPage clickLoginButton() {
        WebElement loginButtonLocator = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButtonLocator.click();
        return new SecureAreaPage(driver);
    }

    public void loginBy(String userName, String password) {
        enterUsername(userName);
        enterPassword(password);
        clickLoginButton();
    }

    public String getActualErrorMessage() {
        WebElement actualMessageLocator = driver.findElement(By.id("flash"));
        return actualMessageLocator.getText();
    }

    public String getExpectErrorMessageUsername() {
        return expectErrorMessageUsername;
    }

    public String getExpectErrorMessagePassword() {
        return expectErrorMessagePassword;
    }

    public String getActualTitleOfPage() {
        WebElement actualTitleOfPageLocator = driver.findElement(By.tagName("h2"));

        return actualTitleOfPageLocator.getText();
    }

    public String getExpectTitleOfPage() {
        return expectTitleOfPage;
    }
}
