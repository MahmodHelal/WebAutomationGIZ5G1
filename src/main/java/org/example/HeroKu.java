package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeroKu {
    WebDriver driver;


    @BeforeClass
    public void setup() {
        driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(), "The Internet", "Title is not correct");
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/", "URL is not correct");
    }

    @BeforeMethod
    public void goToFormAuthenticationPage() {
        WebElement formAuthLink = driver.findElement(By.linkText("Form Authentication"));
        formAuthLink.click();
        Assert.assertEquals(driver.getTitle(), "The Internet", "Title is not correct");

    }

    @Test(priority = 1)
    public void validLogin() {
        WebElement userNameText = driver.findElement(By.id("username"));
        userNameText.sendKeys("tomsmith");
        WebElement passwordText = driver.findElement(By.id("password"));
        passwordText.sendKeys("SuperSecretPassword!");
        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();
        String actualMsg = driver.findElement(By.id("flash")).getText();
        String expectedMsg = "You logged into a secure area!";
//        Assert.assertEquals(actualMsg, expectedMsg, "Login message is not correct");
        Assert.assertTrue(actualMsg.contains(expectedMsg), "Login message is not correct");
        Assert.assertTrue(driver.getCurrentUrl().contains("secure"), "Secure page is not displayed");
        Assert.assertTrue(driver.findElement(By.tagName("h2")).getText().equals("Secure Area"));
        String tileOfSecurePage = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(tileOfSecurePage, "Secure Area", "Title of secure page is not correct");
    }

    @Test(priority = 2)
    public void invalidLoginUsername() {
        WebElement userNameText = driver.findElement(By.id("username"));
        userNameText.sendKeys("WrongUser");
        WebElement passwordText = driver.findElement(By.id("password"));
        passwordText.sendKeys("SuperSecretPassword");
        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();
        String actualMsg = driver.findElement(By.id("flash")).getText();
        String expectedMsg = "Your username is invalid!";
        Assert.assertTrue(actualMsg.contains(expectedMsg), "Invalid Login message is not correct");
        Assert.assertFalse(driver.getCurrentUrl().contains("secure"), "Secure page is displayed");
    }

    @Test(priority = 3)
    public void invalidLoginPassword() {

        System.out.println(driver.getCurrentUrl().contains("login") ? "Login page is displayed" : "Login page is not displayed");
        WebElement userNameText = driver.findElement(By.id("username"));
        userNameText.sendKeys("tomsmith");
        WebElement passwordText = driver.findElement(By.id("password"));
        passwordText.sendKeys("WrongPassword");
        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();
        String actualMsg = driver.findElement(By.id("flash")).getText();
        String expectedMsg = "Your password is invalid!";
        Assert.assertTrue(actualMsg.contains(expectedMsg), "Invalid Login message is not correct");
        Assert.assertFalse(driver.getCurrentUrl().contains("secure"), "Secure page is displayed");

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
