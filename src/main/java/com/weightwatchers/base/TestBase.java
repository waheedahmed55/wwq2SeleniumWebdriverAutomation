package com.weightwatchers.base;

import com.weightwatchers.data.Constants;
import com.weightwatchers.util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver eventdriver;
    public static WebEventListener eventListener;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\application.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startup() {
        String browser = prop.getProperty("BROWSER");
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        /*eventdriver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        eventdriver.register(eventListener);
        driver = eventdriver;*/
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("URL"));
    }

    public static String ReturnCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return days[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }

    public static String ReturnDay() {
        Calendar calendar = Calendar.getInstance();
        String[] days = new String[]{"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        return days[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }
}
