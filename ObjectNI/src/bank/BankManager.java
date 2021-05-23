package bank;

public class BankManager
{
    private int number;
    Account account[]=new Account[]
            {
                    new Account(1001,"和歌山太郎","wakayama",1000),
                    new Account(1002,"和歌山次郎","mikan",2000),
                    new Account(1003,"那智三郎","nachi",10000)
            };

    BankManager()
    {

    }

    boolean login(int inputid,String inputpass)
    {
        boolean flag = false;

        for (int i = 0;i <= 2;i++)
        {
            if(account[i].getId()==inputid)
            {
               if(account[i].getPass().equals(inputpass))
               {
                   number = i;
                   flag = true;
               }
            }
        }
        return flag;
    }

    void deposit(long money)
    {
        money = account[number].getBalance() + money;
        System.out.println("預金残高は"+ money+"です");
    }

    void drawer(long money)
    {
        money = account[number].getBalance() - money;
        System.out.println("預金残高は"+ money+"です");
    }

    void inquires()
    {
        System.out.println("預金残高は"+account[number].getBalance()+"です");
    }

    void payment(int id,long money)
    {
        for(int i = 0;i<=2;i++)
        {
            if(account[i].getId()==id)
            {
                money = account[i].getBalance() + money;
                String name = account[i].getName();
                System.out.println(name+"の預金残高は"+money+"です");
            }
        }
    }

}
