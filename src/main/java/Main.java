import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

import java.*;

public class Main
{
    public static void main(String[] args)
    {
        //SearchItem item = new SearchItem();
        //InternetExplorerDriver driver = item.setProperty();
        //driver = item.openGoogleSearch(driver);
        /*item.setTextToSearchForm(driver, "netcracker official website");
        item.pressLink(driver, "Netcracker – Home", "https://www.netcracker.com");
        driver.quit();*/

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        driver.findElement(By.linkText("Картинки")).click();
    }
}
