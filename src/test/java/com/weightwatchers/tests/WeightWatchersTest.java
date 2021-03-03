package com.weightwatchers.tests;

import com.weightwatchers.base.TestBase;
import com.weightwatchers.data.Constants;
import com.weightwatchers.pages.HomePage;
import com.weightwatchers.pages.WorkShopPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class WeightWatchersTest extends TestBase {

    HomePage homePage;
    WorkShopPage workShopPage;
    String LocationAddress;

    public WeightWatchersTest() {
        super();
    }

    @BeforeClass
    public void setUp() {
        startup();
        homePage = new HomePage(driver);
        workShopPage = new WorkShopPage(driver);
    }

    @Test(priority = 1, description = "Verify Homepage Title")
    public void VerifyHomePageTitleTest() {
        String title = homePage.getPageTitle();
        Assert.assertEquals(title, Constants.HomePageTitle);
    }

    @Test(priority = 2, description = "Verify Find workshop page title")
    public void VerifyFindNavigationWorkshopTest() throws InterruptedException {
        homePage.NavigateToWorkshop();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        if (workShopPage.isStudioDisplayed() == true) {
            String title = homePage.getPageTitle();
            Assert.assertEquals(title, Constants.FindWorkshopTitle);
        }
    }

    @Test(priority = 3, description = "Print Location Name and Distance")
    public void SearchAndPrintResultsTest() throws InterruptedException {
        if (workShopPage.isStudioDisplayed() == true) {
            workShopPage.ClickOnStudio();
            workShopPage.SearchLocation(Constants.ZIPCODE);
            Thread.sleep(6000);
            LocationAddress = workShopPage.ReturnAddress();
            System.out.println("Location Name :" + workShopPage.PrintName());
            System.out.println("Location Distance :" + workShopPage.PrintDistance());
            System.out.println("Location Address :" + workShopPage.ReturnAddress());
        }
    }

    @Test(priority = 4, description = "Verify location page title")
    public void VerifyLocationAndTitleTest() throws InterruptedException {
        if (workShopPage.ResultDisplayed() == true) {
            workShopPage.ClickOnLocation();
            Thread.sleep(6000);
            System.out.println("Location Title :" + homePage.getPageTitle());
            Assert.assertEquals(LocationAddress, homePage.getPageTitle());
        }
    }

    @Test(priority = 5, description = "Print Business Hours")
    public void PrintBusinessHoursTest() throws InterruptedException {
        if (workShopPage.BusinessHoursDisplayed() == true) {
            workShopPage.ClickBusinessHours();
            Thread.sleep(6000);
            System.out.println("Business Hours: " + workShopPage.ReturnBusinessHours(ReturnCurrentDay()));
        }
    }

    @Test(priority = 6, description = "Print Meetings Details")
    public void PrintMeetingsDetailsTest() throws InterruptedException {
        System.out.println("Meetings for the Day: " + ReturnDay());
        workShopPage.printMeetings(ReturnDay());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
