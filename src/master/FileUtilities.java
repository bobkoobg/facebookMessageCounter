package master;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtilities
{

    List<String> fileLines;

    public FileUtilities()
    {
        fileLines = new ArrayList();
    }

    public List<String> readFromFile(String fileName)
    {
        BufferedReader br = null;

        try
        {
            String sCurrentLine;

            br = new BufferedReader(new FileReader(fileName));
            while ((sCurrentLine = br.readLine()) != null)
            {
                fileLines.add(sCurrentLine);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
            fileLines.clear();
            fileLines.add("ERROR" + e);
        }
        finally
        {
            try
            {
                if (br != null)
                {
                    br.close();
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
                fileLines.clear();
                fileLines.add("ERROR" + ex);
            }
        }
        return fileLines;
    }
}
