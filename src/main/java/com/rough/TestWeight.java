package com.rough;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestWeight {

    WebDriver driver;
    String URL;


    @BeforeClass
    public void Initialize() {
        URL = "https://www.weightwatchers.com/us/";
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    public void AMatchTitle() {
        String title = driver.getTitle();
        String ExpectedTitle = "WW (Weight Watchers): Weight Loss Program & Wellness Help | WW USA";
        String QuestionTitle = "WW (Weight Watchers): Weight Loss & Wellness Help | WW USA";
        Assert.assertEquals(title, ExpectedTitle);
    }

    @Test
    public void BFindVirtualWorkshopsNearYou(){
        driver.findElement(By.xpath("//*[text()='Help']")).click();
        driver.findElement(By.xpath("//*[text()='Find a Virtual Workshop']")).click();
        waitForLoad(driver);
        String title = driver.getTitle();
        Assert.assertEquals(title, "Find WW Studios & Meetings Near You | WW USA");
    }

    @Test
    public void FindZipWorkshop(){
        driver.navigate().back();
        driver.findElement(By.id("input-group-8")).sendKeys("10011");
        driver.findElement(By.xpath("//*[@id='input-group-8']/following::div[1]/button")).click();
    }

    @AfterClass
    public void Teardown(){
        driver.quit();
    }

    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
}
