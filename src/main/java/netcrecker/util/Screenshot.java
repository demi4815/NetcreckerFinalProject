package netcrecker.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriverException;

public class Screenshot
{
    public static void screenshot(ChromeDriver driver, String name)
    {
        try
        {
            File file = new File("screenshots/" + name);
            file.delete();
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("screenshots/" + name));
        }
        catch (IOException e)
        {
            System.out.println();
            System.out.println("Failed to take screenshot");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
        }
        catch (WebDriverException e)
        {
            System.out.println();
            System.out.println("Failed to take screenshot");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
        }

    }
}
