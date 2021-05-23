package bank;

public class Account
{
    //口座名義
    private String name;
    private long balance;   //預金残高
    private int id;
    private String pass;

    public Account(int id, String name, String pass, long balance)
    {
        this.name = name;  //口座名義
        this.id = id;
        this.balance = balance;//預金残高
        this.pass = pass;
    }


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPass()
    {
        return pass;
    }

    public void setPass(String pass)
    {
        this.pass = pass;
    }

    public long getBalance()
    {
        return  balance;
    }

    public void setBalance(long balance)
    {
        this.balance = balance;
    }

}
