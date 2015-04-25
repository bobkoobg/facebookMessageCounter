package master;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;

/**
 * Boyko Surlev
 */
public class Logic
{

    Jsoup Jsoup;

    public static void main(String[] args)
    {
        new Logic().base();
    }

    private void base()
    {
        FileUtilities fu = new FileUtilities();
        List<String> fileLines = fu.readFromFile("/media/bobkoo/SWAG/Downloads/friends.htm");
        System.out.println("lines of html code : " + fileLines.size());
        List<String> facebookFriends = extractActualListOfFacebookFriendsFromHTML(fileLines);
        //display friends
        for (int i = 0; i < facebookFriends.size(); i++)
        {
            System.out.println("#" + i + ", value: " + facebookFriends.get(i));
        }
    }

    private List<String> extractActualListOfFacebookFriendsFromHTML(List<String> fileLines)
    {
        List<String> facebookFriends = new ArrayList();

        for (String sCurrentLine : fileLines)
        {

            //Strip starting and ending code of the html line
            sCurrentLine = stripUnnecessaryHTMLCode(sCurrentLine);

            //Names should merge without spaces, so that the split will work properly.
            String sCurrentLineWithoutSpaces = sCurrentLine.replaceAll("\\s+", "");

            //Now the html code should be stripped. A space " " will be left where html was found
            String sCurrentLineStrippedHTML = html2text(sCurrentLineWithoutSpaces);
            
            //Now the differences are distinguishable, because there are spaces between all names
            //We need to split each name, because at the begining we merged them together
            String[] sCurrentLineFriendsNamesWithSpaces = sCurrentLineStrippedHTML.split(" ");
            for (String currentFBFriend : sCurrentLineFriendsNamesWithSpaces)
            {
                if (!facebookFriends.contains(currentFBFriend))
                {
                    char[] particularNameCharacters = currentFBFriend.toCharArray();
                    for (int i = 0; i < particularNameCharacters.length; i++)
                    {
                        //when you find the 2nd upper case (aka Surname), refactor
                        if (i != 0 && Character.isUpperCase(particularNameCharacters[i]))
                        {
                            String firstName = currentFBFriend.substring(0, i);
                            String secondName = currentFBFriend.substring(i, currentFBFriend.length());
                            currentFBFriend = firstName + " " + secondName;
                        }
                    }
                    //add to the actual list of friends
                    facebookFriends.add(currentFBFriend);
                }
            }
        }
        return facebookFriends;
    }
    
    private String stripUnnecessaryHTMLCode(String sCurrentLine){
                    //The hml file has load of unnecessary info - those 2 if statemets removes that.
            if (sCurrentLine.contains("<h2>Friends</h2>"))
            {
                String[] sCurrentLineActualFriendsList = sCurrentLine.split("<h2>Friends</h2>");
                sCurrentLine = sCurrentLineActualFriendsList[1];
            }
            if (sCurrentLine.contains("<h2>Friend Peer Group</h2>"))
            {
                String[] sCurrentLineActualFriendsList = sCurrentLine.split("<h2>Friend Peer Group</h2>");
                sCurrentLine = sCurrentLineActualFriendsList[0];
            }
            return sCurrentLine;
    }

    private String html2text(String html)
    {
        return Jsoup.parse(html).text();
    }

}
