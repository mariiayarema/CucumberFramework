package com.hrms.utils;

import com.hrms.testbase.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonMethods extends PageInitializer {
    /**
     * this method will clear a textbox and send text to it
     * @param element
     * @param textToSend
     */
    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }


    /**
     * this method will return an object of Explicit wait with time set to 20 sec
     * @return WebDriverWait
     */
    public static WebDriverWait getWait(){
        WebDriverWait wait=new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }


    /**
     * This method will wait until given element is visible
     * @param element
     */
    public static void waitForVisibilityOfElement(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
    }



    /**
     * this method will wait until given element becomes clickable
     * @param element
     */
    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * this method will wait till and then click
     */
    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }

    /**
     * this method will return an Object of JavascriptExecutor
     * @return JavascriptExecutor
     */
    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        return js;
    }

    /**
     * this method will click using JavascriptExecutor
     * @param element
     */
    public static void jsClick(WebElement element){
        getJSExecutor().executeScript("arguments[0].click();", element);
    }

    /**
     * This method will return an Object of Select class
     *
     * @param element
     * @return
     */
    public Select getSelect(WebElement element) {
        Select select = new Select(element);
        return select;
    }

    /**
     *
     * @param fileName
     */
    public static byte[] takeScreenshot(String fileName){
        TakesScreenshot ts=(TakesScreenshot)driver;
        byte [] bytes=ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH + fileName + getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        return bytes;
    }
    /**
     *
     * @param pattern
     * @return
     */
    public static String getTimeStamp(String pattern){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * This method will return and Object of Actions class
     * @return
     */
    public static Actions getAction(){
        Actions action=new Actions(driver);

        return action;
    }


    /**
     * This method will moves the mouse to the middle of the element
     * @param element
     */
    public static void moveToElement(WebElement element){
       getAction().moveToElement(element).perform();

        }
    }


