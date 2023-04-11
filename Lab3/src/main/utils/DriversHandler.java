package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class DriversHandler {

    public static List<WebDriver> drivers = new ArrayList<>();
    public static void initDrivers(){
        try {
            drivers.add(addChromeDriver());
            drivers.add(addFireFoxDriver());
        } catch (Exception exception){
            exception.printStackTrace();
            throw new RuntimeException("Web driver is not specified.");
        }
    }

    private static ChromeDriver addChromeDriver(){
        if (ConfigProperties.getProp("driver_chrome") != null){
            System.setProperty("webdriver.chrome.driver", ConfigProperties.getProp("driver_chrome"));
            return new ChromeDriver();
        }
        return null;
    }

    private static FirefoxDriver addFireFoxDriver(){
        if (ConfigProperties.getProp("driver_firefox") != null){
            System.setProperty("webdriver.gecko.driver", ConfigProperties.getProp("driver_firefox"));
            return new FirefoxDriver();
        }
        return null;
    }

    public static void closeDrivers(){
        drivers.forEach(WebDriver::close);
    }
}
