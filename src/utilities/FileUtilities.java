package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import protocol.ProtocolStrings;

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
            fileLines.add(ProtocolStrings.fileReadingError + e);
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
                fileLines.add(ProtocolStrings.fileReadingError + ex);
            }
        }
        return fileLines;
    }
}
