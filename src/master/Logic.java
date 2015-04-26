package master;

import entity.Friend;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.jsoup.Jsoup;
import utilities.FileUtilities;

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
//        List<String> friendsFileLines = fu.readFromFile("/media/bobkoo/SWAG/Downloads/friends.htm");

        //***********************
//        System.out.println("lines of html code : " + friendsFileLines.size());
//        List<String> facebookFriends = extractActualListOfFacebookFriendsFromHTML(friendsFileLines);
//        List<Friend> friends = new ArrayList();
//        for (int i = 0; i < facebookFriends.size(); i++)
//        {
//            friends.add(new Friend(facebookFriends.get(i)));
//        }
        //**************************
        System.out.println("#########################################################################");
        //*************************
        List<String> messagesfileLines = fu.readFromFile("/media/bobkoo/SWAG/Downloads/messages.htm");
        String[] firstLineSplit = messagesfileLines.get(0).split("</h1>");
        String[] nameFinder = firstLineSplit[0].split("<h1>");
        System.out.println("OWNER OF MESSAGES : " + nameFinder[1]);
        
        List<String> strippedFromHTMLMessageFileLines = new ArrayList();
        strippedFromHTMLMessageFileLines.add(firstLineSplit[1]);
        for (int i = 1; i < messagesfileLines.size(); i++)
        {
            strippedFromHTMLMessageFileLines.add(messagesfileLines.get(i));
        }
        //imeto title>Boyko Surlev - Messages</title>
        String line = strippedFromHTMLMessageFileLines.get(37);
        //kolko puti se povtarq <div class="message">

        String[] splitArray = null;

        //so split when the current div class="thread" is over
        splitArray = line.split("</p></div>");

        for (String s : splitArray)
        {
            int counter = 0;
                Pattern p = Pattern.compile("<div class=\"message\">");
                Matcher m = p.matcher(s);
                while (m.find())
                {
                    counter++;
                }    
            
            String[] name = s.split("<div class=\"message\">");
            if (name[0].contains("<div class=\"thread\">"+nameFinder[1]+", "))
            {
                String actualName = name[0].split("<div class=\"thread\">"+nameFinder[1]+", ")[1];
                System.out.println("Name: " + actualName);
            }
            System.out.println("Messages: " + counter);
            System.out.println("# : " + s);
        }

//        List<String> stripped = new ArrayList();
//
//        for (int i = 0; i < messagesfileLines.size(); i++)
//        {
//            stripped.add(html2text(messagesfileLines.get(i)));
//        }
//        for (Friend f : friends)
//        {
//            for (String currentLine : stripped)
//            {
//                Pattern p = Pattern.compile(f.getName());
//                Matcher m = p.matcher(currentLine);
//                while (m.find())
//                {
//                    f.incrementCounter();
//                }
//
//            }
//        }
//
//        Comparator<Friend> comparator = new Comparator<Friend>()
//        {
//            public int compare(Friend c1, Friend c2)
//            {
//                return c2.getCounter() - c1.getCounter(); // use your logic
//            }
//        };
//
//        Collections.sort(friends, comparator); // use the comparator as much as u want
//        for (Friend f : friends)
//        {
//            System.out.println(f.toString());
//        }
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

    private String stripUnnecessaryHTMLCode(String sCurrentLine)
    {
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
