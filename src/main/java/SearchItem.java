import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SearchItem
{
    String name, description, URL;

    protected ChromeDriver setProperty()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        return driver;
    }

    protected void openGoogleSearch(ChromeDriver driver)
    {
        driver.get("http://google.com");
    }

    protected void setTextToSearchForm(ChromeDriver driver, String text)
    {
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys(text);

        driver.findElement(By.xpath("//*[contains(@class, 'FPdoLc')]//*[@name='btnK']")).click();

        try
        {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("netcracker official website.png"));//*[@id="contents"]/span
        }
        catch (IOException e)
        {
            System.out.println("Failed to take screenshot");
        }
    }

    protected void pressLink(ChromeDriver driver, String link, String URL)
    {
        WebElement buttom = driver.findElement(By.xpath("//span[text()='Netcracker - Home']"));
        buttom.click();

        if(!URL.equals(driver.getCurrentUrl()))
        {
            System.out.println("Wrong URL " + driver.getCurrentUrl());
            //URL will always be wrong because you have to accept the agreement
            //and there is another URL
        }

        try
        {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("Netcracker – Home.png"));
        }
        catch (IOException e)
        {
            System.out.println("Failed to take screenshot");
        }
    }

    protected void accept(ChromeDriver driver)
    {
        WebElement buttom = driver.findElement(By.xpath("//span[text()='Accept']"));
        buttom.click();
    }

    protected void netcreckerSearchForm(ChromeDriver driver, String text)
    {
        WebElement buttom1 = driver.findElement(By.xpath("//*[@id='search-button-mobile']//*[contains(@class, 'search-icon')]"));
        buttom1.click();

        WebElement search = driver.findElement(By.xpath("//*[@name='search']"));
        search.sendKeys(text);

        WebElement buttom2 = driver.findElement(By.xpath("//*[contains(@class, 'search-submit-mobile')]//*[contains(@class, 'search-icon')]"));
        buttom2.click();

        try
        {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("USA news.png"));
        }
        catch (IOException e)
        {
            System.out.println("Failed to take screenshot");
        }
    }

    protected void resultsOfSearchFromPage(ChromeDriver driver, ArrayList<SearchItem> list)
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

    protected void contactUs(ChromeDriver driver)
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

        try
        {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("CONTACT US.png"));
        }
        catch (IOException e)
        {
            System.out.println("Failed to take screenshot");
        }
    }



}

