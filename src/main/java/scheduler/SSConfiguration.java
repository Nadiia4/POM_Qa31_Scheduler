package scheduler;

//        "platformName": "Android",
//        "deviceName": "9a77d4bd0506",
//        "platformVersion": "11",
//        "appPackage": "il.co.inetex.scheduler",
//        "appActivity": "il.co.inetex.scheduler.presentation.splashScreen.SplashScreenActivity"


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class SSConfiguration {

protected static AppiumDriver<MobileElement> driver;


@BeforeSuite
    public void setUP() throws MalformedURLException {

    DesiredCapabilities capabilities = new DesiredCapabilities();

    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "9a77d4bd0506");
    capabilities.setCapability("platformVersion", "11");
    //capabilities.setCapability("automationName", "UiAutomator1");//?????
    capabilities.setCapability("appPackage", "il.co.inetex.scheduler");
    capabilities.setCapability("appActivity", "il.co.inetex.scheduler.presentation.splashScreen.SplashScreenActivity");
    capabilities.setCapability("automationName", "Appium");//????????
    capabilities.setCapability("app", "C:/Users/Nadii/v.0.0.3.apk");//1.0.1//v.0.0.3

    driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

}

@AfterSuite
    public void tearDown(){
    //driver.quit();

}

}
