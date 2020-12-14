package netcrecker.testMethods;

import netcrecker.item.SearchItem;
import netcrecker.util.Screenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
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
        try
        {
            WebElement search = driver.findElement(By.name("q"));
            search.sendKeys(text);

            driver.findElement(By.xpath("//*[contains(@class, 'FPdoLc')]//*[@name='btnK']")).click();

            Screenshot.screenshot(driver, "netcracker official website.png");
        }
        catch (NoSuchElementException e)
        {
            System.out.println();
            System.out.println("Error in method setTextToSearchForm()");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
        }

    }

    protected  static void pressLink(ChromeDriver driver, String link, String URL)
    {
        try
        {
            WebElement buttom = driver.findElement(By.xpath("//span[text()='Netcracker - Home']"));
            buttom.click();
        }
        catch (NoSuchElementException e)
        {
            System.out.println();
            System.out.println("Error in method pressLink()");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
        }

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
        try
        {
            WebElement buttom = driver.findElement(By.xpath("//span[text()='Accept']"));
            buttom.click();
        }
        catch (NoSuchElementException e)
        {
            System.out.println();
            System.out.println("Error in method accept()");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    protected static void netcreckerSearchForm(ChromeDriver driver, String text)
    {
        try
        {
            WebElement buttom1 = driver.findElement(By.xpath("//*[@id='search-button-mobile']//*[contains(@class, 'search-icon')]"));
            buttom1.click();

            WebElement search = driver.findElement(By.xpath("//*[@name='search']"));
            search.sendKeys(text);

            WebElement buttom2 = driver.findElement(By.xpath("//*[contains(@class, 'search-submit-mobile')]//*[contains(@class, 'search-icon')]"));
            buttom2.click();
        }
        catch (NoSuchElementException e)
        {
            System.out.println();
            System.out.println("Error in method netcreckerSearchForm()");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
        }

        Screenshot.screenshot(driver, "USA news.png");
    }

    protected static void resultsOfSearchFromPage(ChromeDriver driver, ArrayList<SearchItem> list)
    {
        try
        {
            System.out.println("Showing " + driver.findElement(By.xpath("//*[@id='high']")).getText() + " of "
                    + driver.findElement(By.xpath("//*[@id='total']")).getText() + " Results");
            driver.findElement(By.xpath("//*[contains(@class, 'results-wrapper')]"));

        }
        catch (NoSuchElementException e)
        {
            System.out.println();
            System.out.println("Error in method resultsOfSearchFromPage()");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
        }

        int i = 1;
        boolean flag = true;
        while (flag)
        {
            try
            {
                driver.findElement(By.xpath("//*[contains(@class, 'results-wrapper')]/a[" + i + "]"));//will throw an exception when a ends


                SearchItem item = new SearchItem();

                try
                {
                    item.name = driver.findElement(By.xpath("//*[contains(@class, 'results-wrapper')]/a["
                            + i + "]/div[1]")).getText();
                    item.description = driver.findElement(By.xpath("//*[contains(@class, 'results-wrapper')]/a["
                            + i + "]/div[2]")).getText();
                    item.URL = driver.findElement(By.xpath("//*[contains(@class, 'results-wrapper')]/a["
                            + i + "]/div[3]")).getText();
                }
                catch (NoSuchElementException e)
                {
                    System.out.println();
                    System.out.println("Error in method resultsOfSearchFromPage()");
                    System.out.println();
                    System.out.println(e.getMessage());
                    System.out.println();
                }

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
        try
        {
            //the browser does not open in full screen, so first you need to open the sub menu
            WebElement buttom1 = driver.findElement(By.xpath("//*[contains(@class, 'menu-toggle')]"));
            buttom1.click();

            WebElement buttom2 = driver.findElement(By.xpath("//*[contains(@class, 'sub-menu')]//a[text()='Contact Us']"));
            buttom2.click();
        }
        catch (NoSuchElementException e)
        {
            System.out.println();
            System.out.println("Error in method contactUs()");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
        }

        try
        {
            driver.findElement(By.xpath(" //span[text()='Send Us a Message']"));
        }
        catch (NoSuchElementException e)
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

