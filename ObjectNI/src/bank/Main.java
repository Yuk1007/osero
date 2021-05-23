package bank;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        Scanner scanner5 = new Scanner(System.in);
        Scanner scanner6 = new Scanner(System.in);
        Scanner scanner7 = new Scanner(System.in);

        BankManager bankManager = new BankManager();
        System.out.println("idを入力してください");
        int inputid = scanner1.nextInt();
        System.out.println("パスワードを入力してください");
        String inputpass = scanner2.nextLine();

        if(bankManager.login(inputid,inputpass))
        {
            System.out.println("ログインできました");


            while (true)
            {
                System.out.println("ご用件は？");
                String action = scanner3.nextLine();
                if (action.equals("預け入れ"))
                {
                    long money = scanner4.nextLong();
                    bankManager.deposit(money);
                }
                else if (action.equals("引き出し"))
                {
                    long money = scanner5.nextLong();
                    bankManager.drawer(money);
                }
                else if (action.equals("残高照会"))
                {
                    bankManager.inquires();
                }
                else if(action.equals("口座振り込み"))
                {
                    System.out.println("振り込みたい相手のidを教えてください。");
                    int id  = scanner6.nextInt();
                    System.out.println("振り込みたい金額を教えてください。");
                    long money = scanner7.nextLong();
                    bankManager.payment(id,money);
                }

                if(action.equals("終了"))
                {
                    break;
                }
            }
        }
        else
        {
            System.out.println("ログインできませんでした");
        }
    }

}
