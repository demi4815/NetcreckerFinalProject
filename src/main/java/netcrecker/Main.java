package netcrecker;

import netcrecker.item.SearchItem;
import netcrecker.testMethods.GoogleTestMethods;
import netcrecker.util.LoadToFile;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<SearchItem> list = GoogleTestMethods.allGoogleTestMethods();
        LoadToFile.loadToFile(list);
    }
}
