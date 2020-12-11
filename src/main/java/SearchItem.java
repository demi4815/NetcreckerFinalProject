import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class SearchItem
{
    String name, description, URL;

    File fileXml = new File("Kulikova Karina.txt");

    protected InternetExplorerDriver setProperty()
    {
        System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
        InternetExplorerDriver driver = new InternetExplorerDriver();
        return driver;
    }

    protected InternetExplorerDriver openGoogleSearch(InternetExplorerDriver driver)
    {
        driver.get("http://google.com");
        return driver;
    }

    protected void setTextToSearchForm(InternetExplorerDriver driver, String text)
    {
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys(text);
        WebElement buttom = driver.findElement(By.xpath("//span[contains(text(), '" + text + "')]"));
        buttom.click();
        try
        {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("netcracker official website.png"));
        }
        catch (IOException e)
        {
            System.out.println("Failed to take screenshot");
        }
    }

    protected void pressLink(InternetExplorerDriver driver, String link, String URL)
    {
        WebElement buttom = driver.findElement(By.xpath("//span[contains(text(), '" + link + "')]"));
        buttom.click();

        if(!URL.equals(driver.getCurrentUrl()))
        {
            System.out.println("Wrong URL");
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


}

