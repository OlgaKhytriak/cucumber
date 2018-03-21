package com.epam.task1.driver;


import com.epam.task1.driverproperties.DriverData;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import static com.epam.task1.constant.Constant.GLOBAL_WAIT_TIME;

public class DriverManager {
    private static final Logger LOG = Logger.getLogger(DriverManager.class);
    private static WebDriver driver;

    private DriverManager() {

    }

    protected static WebDriver createDriver() {
        DriverData driverData = new DriverData();
        System.setProperty(driverData.getDriver(), driverData.getUrl());
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(GLOBAL_WAIT_TIME, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getDriver() {

        if (null == driver) {
           driver = createDriver();
        }
        return driver;
    }

}
