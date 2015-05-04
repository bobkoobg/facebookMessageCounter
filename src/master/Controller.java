package master;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import entity.Friend;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    List<String> userAliases;

    //Testing purposes
    public static void main(String[] args)
    {
        new Controller().base();
    }

    //Testing purposes
    private void base()
    {
        //This should check if the file is proper or corrupted or fake
        formatData("/media/bobkoo/SWAG/Downloads/messages.htm");
        omitParticularUserAlias(new ArrayList<String>(Arrays.asList("BoYko Bee", "Córdoba", "La Plata")));
        //omitParticularUserAlias(null);
        getResults();
    }

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

    public boolean omitParticularUserAlias(List<String> userAlias)
    {
        if (userAlias != null)
        {
            userAliases = userAlias;
            return true;
        }
        userAliases = new ArrayList<String>(Arrays.asList(ChatOwner));
        return false;
    }

    public String ownerInformation()
    {
        return "This is the data of " + ChatOwner + ", " + downloadInfo;
    }

    public List<Friend> getResults()
    {
        Friend currentFriend = null;
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
                    String friendName = friendsInCurrentChat.get(0);
                    if (!friendName.contains(";facebook.com") && !userAliases.contains(friendName))
                    {
                        currentFriend = seachFriendsByFriendName(friends, friendName);
                        if (ProtocolStrings.newFriendName.equals(currentFriend.getName()))
                        {
                            currentFriend = new Friend(friendName);
                            friends.add(currentFriend);
                        }
                        extractDateFromCurrentChatMessage(currentChat, currentFriend);
                        counterIncrementer(currentChat, currentFriend, ProtocolStrings.divClassMessage);
                    }
                }
                else
                {
//                    System.out.println("Chat between: ");
//                    for (String s : friendsInCurrentChat)
//                    {
//                        System.out.println("#: " + s);
//                    }
                    for (String currentFriendInChat : friendsInCurrentChat)
                    {
                        String friendName = friendsInCurrentChat.get(0);
                        if (!friendName.contains(";facebook.com") && !userAliases.contains(friendName))
                        {
                            currentFriend = seachFriendsByFriendName(friends, currentFriendInChat);
                            if (ProtocolStrings.newFriendName.equals(currentFriend.getName()))
                            {
                                currentFriend = new Friend(currentFriendInChat);
                                friends.add(currentFriend);
                            }
                            extractDateFromCurrentChatMessage(currentChat, currentFriend);

                            counterIncrementer(currentChat, currentFriend, currentFriendInChat);

                            counterIncrementer(currentChat, currentFriend, friendsInCurrentChat);
                        }
                    }
                }
            }
        }

        FriendsComparator comparator = new FriendsComparator();

        Collections.sort(friends, comparator);
        for (int i = 0; i < friends.size(); i++)
        {
            System.out.println("#:" + (i + 1) + " - " + friends.get(i).toString()
                    + " ###Chat history length : " + daysBetween(friends.get(i).getFirstMessage(), friends.get(i).getLastMessage()));
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

    private void counterIncrementer(String currentChat, Friend newFriend, List<String> friendsInCurrentChat)
    {

        Pattern p = Pattern.compile(ChatOwner);
        Matcher m = p.matcher(currentChat);

        int ownerMessagesCounterInPublicChats = 0;
        while (m.find())
        {
            ownerMessagesCounterInPublicChats++;
        }
        if (ownerMessagesCounterInPublicChats >= friendsInCurrentChat.size())
        {
            int quotaOfVotesForParticularFriendInPublicChat = (ownerMessagesCounterInPublicChats / friendsInCurrentChat.size());
            //System.out.println(newFriend.getName() + " goes from >>> " + newFriend.getCounter() + " to >>> " + (newFriend.getCounter() + quotaOfVotesForParticularFriendInPublicChat));
            newFriend.setCounter(newFriend.getCounter() + quotaOfVotesForParticularFriendInPublicChat);

        }
    }

    private List<String> extractFriendsFromCurrentChat(String currentChat, String ChatOwner)
    {
        List<String> listOfFriendsInCurrentChat = new ArrayList();
        String stringOfPeopleInChat = null;
        if (currentChat.contains(ProtocolStrings.divClassThread))
        {
            //2 thats the logic.. should be sth like that (to extract time)
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

    private void extractDateFromCurrentChatMessage(String currentChat, Friend currentFriend)
    {
        //lets say we reach the point where we can extract every meta
        //from every chat message

        String[] messages = currentChat.split(ProtocolStrings.divClassMessage);
        for (String currentMessage : messages)
        {
            if (currentMessage.contains("<span class=\"meta\">"))
            {
                int endOfSpan = currentMessage.indexOf("</span></div></div>");
                int startOfSpan = currentMessage.indexOf("<span class=\"meta\">");
                int lengthOfStartofSpan = "<span class=\"meta\">".length();
                String spanClassMeta = null;
                if (endOfSpan != -1)
                {
                    spanClassMeta = currentMessage.substring(lengthOfStartofSpan + startOfSpan, endOfSpan);
                }
                int startOfComma = spanClassMeta.indexOf(", ");
                int startOfAt = spanClassMeta.indexOf(" at");
                String actualDate = null;
                if (endOfSpan != -1)
                {
                    actualDate = spanClassMeta.substring(startOfComma + 2, startOfAt);
                }
                Date currentMessageDateTime = null;
                DateFormat df = new SimpleDateFormat("MMM dd, yyyy");
                try
                {
                    currentMessageDateTime = df.parse(actualDate);
                }
                catch (ParseException ex)
                {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                //System.out.println("Date: " + currentMessageDateTime.toString());

                //The actual logic
                if (currentFriend.getFirstMessage() != null)
                {
                    if (currentMessageDateTime.before(currentFriend.getFirstMessage()))
                    {
                        currentFriend.setFirstMessage(currentMessageDateTime);
                    }
                }
                else
                {
                    currentFriend.setFirstMessage(currentMessageDateTime);
                }

                if (currentFriend.getLastMessage() != null)
                {
                    if (currentMessageDateTime.after(currentFriend.getLastMessage()))
                    {
                        currentFriend.setLastMessage(currentMessageDateTime);
                    }
                }
                else
                {
                    currentFriend.setLastMessage(currentMessageDateTime);
                }
            }

        }
    }

    public int daysBetween(Date d1, Date d2)
    {
        return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public static Friend seachFriendsByFriendName(List<Friend> list, String name)
    {
        for (Friend object : list)
        {
            if (object.getName().equals(name))
            {
                return object;
            }
        }
        return new Friend(ProtocolStrings.newFriendName);
    }
}
