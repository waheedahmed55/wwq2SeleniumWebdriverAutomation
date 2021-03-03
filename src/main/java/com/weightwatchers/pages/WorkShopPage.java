package com.weightwatchers.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class WorkShopPage {

    WebDriver driver;

    By Studio = By.xpath(".//*[text()='Studio']");
    By Location = By.id("location-search");
    By LocationSearch = By.id("location-search-cta");
    By ResultName = By.xpath(".//*[@id='search-results']//descendant-or-self::div[starts-with(@id,'location')]/a/div/div/a[1]");
    By ResultDistance = By.xpath(".//*[@id='search-results']//descendant-or-self::div[starts-with(@id,'location')]/a/div/span[1]");
    By Address1 = By.xpath(".//*[@id='search-results']//descendant-or-self::div[starts-with(@id,'location')]/a/div[2]/div[1]");
    By Address2 = By.xpath(".//*[@id='search-results']//descendant-or-self::div[starts-with(@id, 'location')]/a/div[2]/div[2]");
    By BusinessHours = By.xpath(".//*[text()='Business hours']");

    public WorkShopPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isStudioDisplayed() {
        return driver.findElement(Studio).isDisplayed();
    }

    public void ClickOnStudio() {
        driver.findElement(Studio).click();
    }

    public void SearchLocation(String location) {
        driver.findElement(Location).sendKeys(location);
        driver.findElement(LocationSearch).click();
    }

    public String PrintName() {
        return driver.findElement(ResultName).getText();
    }

    public String PrintDistance() {
        return driver.findElement(ResultDistance).getText();
    }

    public boolean ResultDisplayed() {
        return driver.findElement(ResultName).isDisplayed();
    }

    public void ClickOnLocation() {
        driver.findElement(ResultName).click();
    }

    public String ReturnAddress() {
        String FAddress1 = driver.findElement(Address1).getText();
        String SAddress2 = driver.findElement(Address2).getText();
        String CombinedAddress = "Meeting Location: " + FAddress1 + ", " + SAddress2 + " | WW USA";
        return CombinedAddress;
    }

    public void ClickBusinessHours() {
        driver.findElement(BusinessHours).click();
    }

    public boolean BusinessHoursDisplayed() {
        return driver.findElement(BusinessHours).isDisplayed();
    }

    public String ReturnBusinessHours(String DayName) {
        WebElement dayDisplayed = driver.findElement(By.xpath(".//*[text()='Business hours']/following::div[text()='" + DayName + "']/following::div[1]"));
        return dayDisplayed.getText();
    }

    public void printInPersonMeetings(String DayName) {
        try {
            System.out.println("-------Studio Workshops schedule (in-person)-------");
            ArrayList<String> l = new ArrayList<String>();
            List<WebElement> links = driver.findElements(By.xpath("//div[@id='main']/div[1]/div[4]/div[3]/div/span[text()='" + DayName + "']/following-sibling::div/span[2]"));
            if (links.size() != 0){
                for (int i = 1; i <= links.size(); i++) {
                    String meeting = driver.findElement(By.xpath("//div[@id='main']/div[1]/div[4]/div[3]/div/span[text()='" + DayName + "']/following-sibling::div[" + i + "]/span[2]")).getText();
                    l.add(meeting);
                }
                Set<String> person = new HashSet<String>(l);
                for (String s : person) {
                    System.out.println(s + ": " + Collections.frequency(l, s));
                }
            }else {
                System.out.println("No Meetings for the Day");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void printVirtualMeetings(String DayName) {
        try {
            System.out.println("-------Virtual Workshops schedule-------");
            ArrayList<String> l = new ArrayList<String>();
            List<WebElement> links = driver.findElements(By.xpath("//div[@id='main']/div[1]/div[5]/div[3]/div/span[text()='" + DayName + "']/following-sibling::div/span[2]"));
            if (links.size() != 0){
                for (int i = 1; i <= links.size(); i++) {
                    String meeting = driver.findElement(By.xpath("//div[@id='main']/div[1]/div[5]/div[3]/div/span[text()='" + DayName + "']/following-sibling::div[" + i + "]/span[2]")).getText();
                    l.add(meeting);
                }
                Set<String> person = new HashSet<String>(l);
                for (String s : person) {
                    System.out.println(s + ": " + Collections.frequency(l, s));
                }
            }else {
                System.out.println("No Meetings for the Day");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void printMeetings(String DayName){
        printInPersonMeetings(DayName);
        printVirtualMeetings(DayName);
    }
}
