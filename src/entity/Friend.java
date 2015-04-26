package entity;

public class Friend
{

    private String name;
    private Integer counter;

    public Friend(String name)
    {
        this.name = name;
        counter = 0;
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

    @Override
    public String toString()
    {
        return name + ", messages: " + counter;
    }
}
