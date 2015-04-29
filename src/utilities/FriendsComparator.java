package utilities;

import entity.Friend;
import java.util.Comparator;

    public class FriendsComparator implements Comparator<Friend>
    {

        @Override
        public int compare(Friend c1, Friend c2)
        {
            return c2.getCounter() - c1.getCounter();
        }
    }
