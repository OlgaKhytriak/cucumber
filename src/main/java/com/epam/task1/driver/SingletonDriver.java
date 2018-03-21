package com.epam.task1.driver;

import com.epam.task1.driverproperties.DriverData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import static com.epam.task1.constant.Constant.GLOBAL_WAIT_TIME;

public class SingletonDriver {
        private static Map<Long, WebDriver> drivers = new HashMap<>();
        private static Semaphore semaphore = new Semaphore(3);

        private SingletonDriver() {
        }

        private static WebDriver newInstance() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            DriverData driverData = new DriverData();
            System.setProperty(driverData.getDriver(), driverData.getUrl());
            return new ChromeDriver() {
                {
                    manage().timeouts().implicitlyWait(GLOBAL_WAIT_TIME, TimeUnit.SECONDS);
                }
            };
        }

        public static WebDriver getDriver() {
            return drivers.computeIfAbsent(Thread.currentThread().getId(), f -> newInstance());
        }

        public static void releaseThread() {
            SingletonDriver.getDriver().quit();
            drivers.remove(Thread.currentThread().getId());
            semaphore.release();
        }

        public static void releaseAllThreads() {
            for (Map.Entry<Long, WebDriver> entry : drivers.entrySet()) {
                entry.getValue().quit();
                semaphore.release();
            }
            drivers.clear();
        }
    }
