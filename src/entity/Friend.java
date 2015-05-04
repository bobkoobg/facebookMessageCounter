package entity;

import java.util.Date;

public class Friend
{

    private String name;
    private Integer counter;
    private Date firstMessage;
    private Date lastMessage;

    public Friend(String name)
    {
        this.name = name;
        counter = 0;
        firstMessage = null;
        lastMessage = null;
    }

    public String getName()
    {
        return name;
    }

    public Integer getCounter()
    {
        return counter;
    }

    public void setCounter(Integer counter)
    {
        this.counter = counter;
    }

    public Integer incrementCounter()
    {
        return counter++;
    }

    public void setFirstMessage(Date firstMessage)
    {
        this.firstMessage = firstMessage;
    }

    public void setLastMessage(Date lastMessage)
    {
        this.lastMessage = lastMessage;
    }

    public Date getFirstMessage()
    {
        return firstMessage;
    }

    public Date getLastMessage()
    {
        return lastMessage;
    }

    @Override
    public String toString()
    {
        if (firstMessage != null && lastMessage != null)
        {
            return name + ", messages: " + counter
                    + " [First message: " + firstMessage.toString()
                    + " , Last message: " + lastMessage.toString() + " ]";
        }
        return name + ", messages: " + counter;

    }
}
