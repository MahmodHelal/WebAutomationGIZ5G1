package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.formPackage.FormAuthPage;

public class HeroHomePage {
    WebDriver driver;

    public HeroHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public FormAuthPage navigateToFormAuthenticationPage() {
        // Code to navigate to the Form Authentication page
        WebElement formAuthLink = driver.findElement(By.linkText("Form Authentication"));
        formAuthLink.click();
        return new FormAuthPage(driver);
    }


    public void navigateToCheckboxPage() {
        WebElement checkBoxLink = driver.findElement(By.linkText("Checkboxes"));
        checkBoxLink.click();
    }


}
