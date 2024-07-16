package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {


    //driver class i webdriver objesini oluturuacagiz
    // ve gerekli ayarlari yaptigimiz class olacak
    // hedef configuration properties

  public static WebDriver driver;




    public static WebDriver getDriver(){


        if (driver==null) {
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;

    }


    public static void quitDriver(){

        driver.quit();
        driver=null;



    }

}
