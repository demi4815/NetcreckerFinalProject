package netcrecker.util;

import netcrecker.item.SearchItem;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LoadToFile
{
    public static void loadToFile(ArrayList<SearchItem> list)
    {
        try
        {
            File file = new File("file/Kulikova Karina.txt");
            file.delete();
            FileWriter writer = new FileWriter(new File("file/Kulikova Karina.txt"));

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
            System.out.println();
            System.out.println("Failed to create file or write to file");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();

            for (SearchItem searchItem : list)
            {
                System.out.println(searchItem.name);
                System.out.println(searchItem.description);
                System.out.println(searchItem.URL);
                System.out.println();
            }
        }
    }
}
