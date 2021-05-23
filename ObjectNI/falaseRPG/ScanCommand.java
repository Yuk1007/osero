package rpg;

import java.util.Scanner;

/**
 * キーボードから値を読み込むクラス
 * 数値以外が入力された場合，もう一度入力をやり直させる
 *　使い方：
 *　初めのMainクラスでコンストラクタを呼び出し生成し，他のクラスで用いる場合は引数として渡して利用する．
 *
 */
public class ScanCommand {
	private static Scanner scan= new Scanner(System.in);

	public static int scan() {
		while(true){
			try {
				int command = scan.nextInt();
				return command;
			} catch(Exception e){
				System.out.println("正しい値を入力してください");
				scan.next();
			}
		}
	}

	public static void close() {
		scan.close();
	}
}
