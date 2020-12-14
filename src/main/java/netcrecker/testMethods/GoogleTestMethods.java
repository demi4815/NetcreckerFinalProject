package netcrecker.testMethods;

import netcrecker.item.SearchItem;
import netcrecker.util.Screenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GoogleTestMethods
{
    protected static ChromeDriver setProperty()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        return driver;
    }

    protected  static void openGoogleSearch(ChromeDriver driver)
    {
        driver.get("http://google.com");
    }

    protected  static void setTextToSearchForm(ChromeDriver driver, String text)
    {
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys(text);

        driver.findElement(By.xpath("//*[contains(@class, 'FPdoLc')]//*[@name='btnK']")).click();

        Screenshot.screenshot(driver, "netcracker official website.png");
    }

    protected  static void pressLink(ChromeDriver driver, String link, String URL)
    {
        WebElement buttom = driver.findElement(By.xpath("//span[text()='Netcracker - Home']"));
        buttom.click();

        if(!URL.equals(driver.getCurrentUrl()))
        {
            System.out.println("Wrong URL " + driver.getCurrentUrl());
            //URL will always be wrong because you have to accept the agreement
            //and there is another URL
        }

        Screenshot.screenshot(driver, "Netcracker – Home.png");
    }

    protected static void accept(ChromeDriver driver)
    {
        WebElement buttom = driver.findElement(By.xpath("//span[text()='Accept']"));
        buttom.click();
    }

    protected static void netcreckerSearchForm(ChromeDriver driver, String text)
    {
        WebElement buttom1 = driver.findElement(By.xpath("//*[@id='search-button-mobile']//*[contains(@class, 'search-icon')]"));
        buttom1.click();

        WebElement search = driver.findElement(By.xpath("//*[@name='search']"));
        search.sendKeys(text);

        WebElement buttom2 = driver.findElement(By.xpath("//*[contains(@class, 'search-submit-mobile')]//*[contains(@class, 'search-icon')]"));
        buttom2.click();

        Screenshot.screenshot(driver, "USA news.png");
    }

    protected static void resultsOfSearchFromPage(ChromeDriver driver, ArrayList<SearchItem> list)
    {
        System.out.println("Showing " + driver.findElement(By.xpath("//*[@id='high']")).getText() + " of "
                + driver.findElement(By.xpath("//*[@id='total']")).getText() + " Results");
        driver.findElement(By.xpath("//*[contains(@class, 'results-wrapper')]"));

        int i = 1;
        boolean flag = true;
        while (flag)
        {
            try
            {
                driver.findElement(By.xpath("//*[contains(@class, 'results-wrapper')]/a[" + i + "]"));

                SearchItem item = new SearchItem();
                item.name = driver.findElement(By.xpath("//*[contains(@class, 'results-wrapper')]/a["
                        + i + "]/div[1]")).getText();
                item.description = driver.findElement(By.xpath("//*[contains(@class, 'results-wrapper')]/a["
                        + i + "]/div[2]")).getText();
                item.URL = driver.findElement(By.xpath("//*[contains(@class, 'results-wrapper')]/a["
                        + i + "]/div[3]")).getText();

                list.add(item);

                i++;
            }
            catch (Exception e)
            {
                flag = false;
            }
        }

    }

    protected static void contactUs(ChromeDriver driver)
    {
        //the browser does not open in full screen, so first you need to open the sub menu
        WebElement buttom1 = driver.findElement(By.xpath("//*[contains(@class, 'menu-toggle')]"));
        buttom1.click();

        WebElement buttom2 = driver.findElement(By.xpath("//*[contains(@class, 'sub-menu')]//a[text()='Contact Us']"));
        buttom2.click();

        try
        {
            driver.findElement(By.xpath(" //span[text()='Send Us a Message']"));
        }
        catch (Exception e)
        {
            System.out.println("Link 'Send Us a Message' does not exist");
        }

        Screenshot.screenshot(driver, "CONTACT US.png");
    }

    public static ArrayList<SearchItem> allGoogleTestMethods()
    {
        ChromeDriver driver = setProperty();
        openGoogleSearch(driver);
        setTextToSearchForm(driver, "netcracker official website");
        pressLink(driver, "Netcracker – Home", "https://www.netcracker.com");
        accept(driver);
        netcreckerSearchForm(driver, "USA");
        ArrayList<SearchItem> list = new ArrayList<SearchItem>();
        resultsOfSearchFromPage(driver, list);
        contactUs(driver);
        driver.quit();
        return list;
    }



}

