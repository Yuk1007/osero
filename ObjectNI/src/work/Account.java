package work;

public class Account {
    private static int counter = 0;
    private String name;        //口座名義
    private String no;             //口座番号
    private long balance;   //預金残高
    private int id;
    public Account(String name, String no, long balance) {

        this.name = name;  //口座名義

        this.no = no;  //口座番号

        this.balance = balance;  //預金残高

        this.id = ++counter;
    }
}
