package com.epam.task1.driver;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.Semaphore;

public class SafeThreadDriverCreator {

    private static SafeThreadDriverCreator instance = new SafeThreadDriverCreator();

    private SafeThreadDriverCreator() {

    }

    public static SafeThreadDriverCreator getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<WebDriver>() // thread local driverThreadLocal object for webdriver
    {
        @Override
        protected WebDriver initialValue() {
            return DriverManager.getDriver();
        }
    };

    public WebDriver getDriverThreadLocal() {
        return driverThreadLocal.get();
    }

    public void removeDriver() {
        if (driverThreadLocal.get() != null) {
            try {
                driverThreadLocal.get().quit();
            } catch (Exception e) {
                System.out.println("Exception in driver remove");
            }
            driverThreadLocal.remove();
        }
    }
}

