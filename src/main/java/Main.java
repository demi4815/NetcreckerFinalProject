import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {

        SearchItem item = new SearchItem();
        ChromeDriver driver = item.setProperty();
        item.openGoogleSearch(driver);
        item.setTextToSearchForm(driver, "netcracker official website");
        item.pressLink(driver, "Netcracker – Home", "https://www.netcracker.com");
        item.accept(driver);
        item.netcreckerSearchForm(driver, "USA");
        ArrayList<SearchItem> list = new ArrayList<SearchItem>();
        item.resultsOfSearchFromPage(driver, list);
        item.contactUs(driver);
        driver.quit();

        try
        {
            //File file = new File("Kulikova Karina.txt");
            //FileWriter writer = new FileWriter(file);
            FileWriter writer = new FileWriter("Kulikova Karina.txt");

            for (SearchItem searchItem : list) {
                writer.write(searchItem.name);
                writer.append('\n');
                writer.write(searchItem.description);
                writer.append('\n');
                writer.write(searchItem.URL);
                writer.append('\n');
                writer.append('\n');
            }

            writer.flush();
        }
        catch (IOException e)
        {
            System.out.println("Failed to create file or write to file");
        }

    }
}
