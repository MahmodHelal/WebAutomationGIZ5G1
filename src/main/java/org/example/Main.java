package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

// create new session
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        String currentTitle = driver.getTitle();
        String currentURL = driver.getCurrentUrl();

        System.out.println("Title is " + currentTitle);
        System.out.println("URL is " + currentURL);
        driver.navigate().to("https://www.saucedemo.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();


        WebElement userNameText = driver.findElement(By.id("username"));
        userNameText.sendKeys("standard_user");
        Thread.sleep(600);

        WebElement passwordText = driver.findElement(By.id("password"));
        passwordText.sendKeys("secret_sauce");
        Thread.sleep(600);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(600);





/*        driver.close(); // close tab
        driver.quit(); // close session*/


    }
}