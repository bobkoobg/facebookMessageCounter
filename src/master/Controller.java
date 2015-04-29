package master;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import entity.Friend;
import protocol.ProtocolStrings;
import utilities.FileUtilities;
import utilities.FriendsComparator;
import utilities.MapSorter;

/**
 * Boyko Surlev
 */
public class Controller
{

    MapSorter ms;
    Map<Integer, String> strippedFromHTMLMessageFileLines;
    String ChatOwner;
    String downloadInfo;

//    //Testing purposes
//    public static void main(String[] args)
//    {
//        new Controller().base();
//    }
//
//    //Testing purposes
//    private void base()
//    {
//        formatData("/media/bobkoo/SWAG/Downloads/messages.htm");
//        getResults();
//    }

    public boolean formatData(String path)
    {
        FileUtilities fu = new FileUtilities();
        List<String> fileLines = fu.readFromFile(path);
        if (!fileLines.contains(ProtocolStrings.fileReadingError))
        {
            ms = new MapSorter(fileLines);

            strippedFromHTMLMessageFileLines = ms.getHashMapWithMessagesOnly();
            ChatOwner = ms.getMessageOwnerName();
            downloadInfo = ms.getMessageDownloadInfo();
            System.out.println("This is the data of " + ChatOwner + ", " + downloadInfo);

            System.out.println("#########################################################################");

            return true;
        }
        return false;
    }
    
    public String ownerInformation(){
        return "This is the data of " + ChatOwner + ", " + downloadInfo;
    }

    public List<Friend> getResults()
    {
        Friend newFriend = null;
        List<Friend> friends = new ArrayList();
        List<String> friendsInCurrentChat = new ArrayList();

        for (int i = 0; i < strippedFromHTMLMessageFileLines.size(); i++)
        {
            String[] chats = strippedFromHTMLMessageFileLines.get(i).split(ProtocolStrings.endTagPandEndTagDiv);

            for (String currentChat : chats)
            {
                if (!extractFriendsFromCurrentChat(currentChat, ChatOwner).isEmpty())
                {
                    friendsInCurrentChat = extractFriendsFromCurrentChat(currentChat, ChatOwner);
                }

                if (friendsInCurrentChat.size() == 1 || friendsInCurrentChat.isEmpty())
                {
                    newFriend = seachFriendsByFriendName(friends, friendsInCurrentChat.get(0));
                    if (ProtocolStrings.newFriendName.equals(newFriend.getName()))
                    {
                        newFriend = new Friend(friendsInCurrentChat.get(0));
                        friends.add(newFriend);
                    }

                    counterIncrementer(currentChat, newFriend, ProtocolStrings.divClassMessage);
                }
                else
                {
                    for (String currentFriendInChat : friendsInCurrentChat)
                    {
                        newFriend = seachFriendsByFriendName(friends, currentFriendInChat);
                        if (ProtocolStrings.newFriendName.equals(newFriend.getName()))
                        {
                            newFriend = new Friend(currentFriendInChat);
                            friends.add(newFriend);
                        }
                        counterIncrementer(currentChat, newFriend, currentFriendInChat);
                    }
                }
            }
        }

        FriendsComparator comparator = new FriendsComparator();

        Collections.sort(friends, comparator);
        for (Friend f : friends)
        {
            System.out.println(f.toString());
        }

        return friends;
    }

    private void counterIncrementer(String currentChat, Friend newFriend, String pattern)
    {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(currentChat);
        while (m.find())
        {
            newFriend.incrementCounter();
        }
    }

    private List<String> extractFriendsFromCurrentChat(String currentChat, String ChatOwner)
    {
        List<String> listOfFriendsInCurrentChat = new ArrayList();
        String stringOfPeopleInChat = null;
        if (currentChat.contains(ProtocolStrings.divClassThread))
        {
            int endIndex = currentChat.indexOf(ProtocolStrings.divClassMessage);
            int startIndex = currentChat.indexOf(ProtocolStrings.divClassThread);
            int lengthOfStart = ProtocolStrings.divClassThread.length();
            if (endIndex != -1)
            {
                stringOfPeopleInChat = currentChat.substring(startIndex + lengthOfStart, endIndex);
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

    public static Friend seachFriendsByFriendName(List<Friend> list, String name)
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
        return new Friend(ProtocolStrings.newFriendName);
    }
}
