package work;

import java.util.HashMap;

public class Warehouse
{
    private final Integer stockMax = 100; // 在庫制限
    private HashMap<String, Integer> items; // 貯蔵する商品と在庫数

    public Warehouse()
    {
        this.items = new HashMap<String, Integer>();
    }

    // itemsのgetter
    public HashMap<String, Integer> getItems()
    {
        return this.items;
    }

    // 商品の貯蔵
    public void storeItem(String itemName, Integer stock)
    {
        // stockが負の値の場合は無効
        if (stock < 0)
        {
            System.out.println("不正な値が入力されました");
            return;
        }

        // 商品が存在しない場合に新しい商品を登録する　在庫数が上限より多くならないようにする
        if (!this.items.containsKey(itemName))
        {
            if (stock < this.stockMax)
            {
                this.items.put(itemName, stock); // {itemName}という商品を{stock}個登録
                System.out.println(stock + "個の" + itemName + "を登録しました");
            }
            else
            {
                this.items.put(itemName, this.stockMax);
                System.out.println(this.stockMax + "より多くの商品を貯蔵できません");
                System.out.println(this.stockMax + "個の" + itemName + "を登録しました");
            }
            return;
        }

        // 商品の貯蔵
        if (items.get(itemName) + stock < this.stockMax)
        {
            this.items.put(itemName, this.items.get(itemName) + stock);
            System.out.println(itemName + "を" + stock + "個貯蔵しました");
        }
        else
        { // 在庫数が上限に達するとそれ以上貯蔵しないようにする
            this.items.put(itemName, this.stockMax);
            System.out.println(itemName + "を" + stock + "個貯蔵しました");
            System.out.println(itemName + "の在庫数が限界に達しました");
        }
    }

    // 商品の取り出し
    public void takeItem(String itemName, Integer stock)
    {
        // stockが負の値の場合は無効
        if (stock < 0)
        {
            System.out.println("不正な値が入力されました");
            return;
        }

        // 存在しない商品は取り出せない
        if (!this.items.containsKey(itemName))
        {
            System.out.println(itemName + "という商品は存在しません");
            return;
        }

        // 商品の取り出し　
        if (this.items.get(itemName) - stock > 0)
        {
            this.items.put(itemName, items.get(itemName) - stock);
            System.out.println(itemName + "を" + stock + "個取り出しました");
        }
        else
        { //在庫数が0になると商品を取り出せないようにする
            this.items.put(itemName, 0);
            System.out.println(itemName + "を" + stock + "個取り出しました");
            System.out.println(itemName + "の在庫数が0になりました");
        }
    }

    // 商品と在庫数の表示
    public void printItems()
    {
        for (String itemName : this.items.keySet())
        {
            System.out.println("商品名: " + itemName + " 在庫数: " + this.items.get(itemName));
        }
    }
}
