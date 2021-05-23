package work;

public class Shop
{
    public int id;
    public String shopName;
    public int sales; //1つの店舗での売り上げ
    public static int allSales = 0; //全体の店舗での売り上げ

    public Shop(int id, String shopName)
    {
        this.id = id;
        this.shopName = shopName;
        this.sales = 0;
    }

    // customersは客数でpriceは売る商品の値段．{customers}人に{price}円の商品を売るメソッド
    public void sell(int customers, int price)
    {
        int soldPrice = customers * price;
        this.sales += soldPrice;
        Shop.allSales += soldPrice;
    }
}
