package com.weightwatchers.pages;

import com.weightwatchers.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;

    By helpBtn = By.xpath("//*[text()='Help']");
    By findWorkshopBtn = By.xpath("//*[text()='Find a Virtual Workshop']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void NavigateToWorkshop() throws InterruptedException {
        WebElement help = driver.findElement(helpBtn);
        WebElement findWorkshop = driver.findElement(findWorkshopBtn);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        help.click();
        Thread.sleep(3000);
        findWorkshop.click();
       }

}
