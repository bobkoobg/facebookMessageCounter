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

        Friend newFriend = null;
        List<Friend> friends = new ArrayList();
        List<String> friendsInCurrentChat = new ArrayList();

        for (int i = 0; i < strippedFromHTMLMessageFileLines.size(); i++)
        {
            String[] chats = strippedFromHTMLMessageFileLines.get(i).split("</p></div>");

            for (String currentChat : chats)
            {
                if (!extractFriendsInCurrentChat(currentChat, nameFinder[1]).isEmpty())
                {
                    friendsInCurrentChat = extractFriendsInCurrentChat(currentChat, nameFinder[1]);
                }

                //if (name[0].contains("<div class=\"thread\">" + nameFinder[1] + ", "))
                if (friendsInCurrentChat.size() == 1 || friendsInCurrentChat.isEmpty())
                {
                    newFriend = giveMeFriend(friends, friendsInCurrentChat.get(0));
                    if ("NEW".equals(newFriend.getName()))
                    {
                        newFriend = new Friend(friendsInCurrentChat.get(0));
                        friends.add(newFriend);
                    }

                    counterBoy(currentChat, newFriend, "<div class=\"message\">");

                    //newFriend.setCounter(newFriend.getCounter() + counter);
                }
                else
                {
                    for (String currentFriendInChat : friendsInCurrentChat)
                    {
                        newFriend = giveMeFriend(friends, currentFriendInChat);
                        if ("NEW".equals(newFriend.getName()))
                        {
                            //System.out.println("We failed with : " + currentFriendInChat);
                            newFriend = new Friend(currentFriendInChat);
                            friends.add(newFriend);
                        }

//                        int counter2 = 0;
//                        Pattern p2 = Pattern.compile(currentFriendInChat);
//                        Matcher m2 = p2.matcher(currentChat);
//                        while (m2.find())
//                        {
//                            counter2++;
//                        }
//
//                        newFriend.setCounter(newFriend.getCounter() + counter2);
                        counterBoy(currentChat, newFriend, currentFriendInChat);
                    }
                }

            }
        }

        Comparator<Friend> comparator = new Comparator<Friend>()
        {
            public int compare(Friend c1, Friend c2)
            {
                return c2.getCounter() - c1.getCounter(); // use your logic
            }
        };

        Collections.sort(friends, comparator); // use the comparator as much as u want
        for (Friend f : friends)
        {
            System.out.println(f.toString());
        }
    }

    private void counterBoy(String currentChat, Friend newFriend, String pattern)
    {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(currentChat);
        while (m.find())
        {
            newFriend.incrementCounter();
        }
        //return newFriend;
    }

    private List<String> extractFriendsInCurrentChat(String currentChat, String ChatOwner)
    {
        List<String> listOfFriendsInCurrentChat = new ArrayList();
        String stringOfPeopleInChat = null;
        if (currentChat.contains("<div class=\"thread\">"))
        {
            int endIndex = currentChat.indexOf("<div class=\"message\">");
            int startIndex = currentChat.indexOf("<div class=\"thread\">");
            int lengthOfStart = "<div class=\"thread\">".length();
            // System.out.println("start index " + startIndex);
            if (endIndex != -1)
            {
                stringOfPeopleInChat = currentChat.substring(startIndex + lengthOfStart, endIndex); // not forgot to put check if(endIndex != -1)
            }

            String[] arrayOfPeopleInChat = stringOfPeopleInChat.split(", ");
            for (String currentPerson : arrayOfPeopleInChat)
            {
                if (!ChatOwner.equals(currentPerson))
                {
                    listOfFriendsInCurrentChat.add(currentPerson);
                }
            }

        }

        return listOfFriendsInCurrentChat;
    }

    public static Friend giveMeFriend(List<Friend> list, String name)
    {
        for (Friend object : list)
        {
            //System.out.println("object.getName() : " + object.getName());
            //System.out.println("name : " + name);
            if (object.getName().equals(name))
            {
                //System.out.println("Found ONE!");
                return object;
            }
        }
        return new Friend("NEW");
    }

    private String html2text(String html)
    {
        return Jsoup.parse(html).text();
    }

}
