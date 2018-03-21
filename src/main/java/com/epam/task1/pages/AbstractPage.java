package com.epam.task1.pages;

import static com.epam.task1.constant.Constant.ALERT_WAIT_TIME;

import com.epam.task1.driver.SafeThreadDriverCreator;
import com.epam.task1.driver.SingletonDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.epam.task1.decorator.CustomFieldDecorator;


public abstract class AbstractPage {
    private static final Logger LOG = Logger.getLogger(AbstractPage.class);
    protected WebDriver driver;

    public AbstractPage() {
        //driver = SingletonDriver.getDriver();
        this.driver = SafeThreadDriverCreator.getInstance().getDriverThreadLocal();
        PageFactory.initElements(new CustomFieldDecorator(driver), this);

    }

    public void openPage(String pageURL) {
        driver.get(pageURL);
        if (isAlertPresent()) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }

     public boolean isAlertPresent() {
        boolean foundAlert = false;
        WebDriverWait wait = new WebDriverWait(driver, ALERT_WAIT_TIME);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        } catch (TimeoutException eTO) {

        }
        return foundAlert;
    }
}
