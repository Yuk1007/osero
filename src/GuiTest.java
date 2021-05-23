import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class GuiTest extends JFrame 
{
	private JButton[][] buttonArray;	//ボタン用の配列
	private Container c;

	public GuiTest() 
	{
		//ウィンドウを作成する
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ウィンドウを閉じるときに，正しく閉じるように設定する
		this.setTitle("Gui Test");		//ウィンドウのタイトルを設定する
		this.setSize(450,450);		//ウィンドウのサイズを設定する
		c = this.getContentPane();	//フレームのペインを取得する
		c.setLayout(null);		//自動レイアウトの設定を行わない

		//ボタンの生成
		buttonArray = new JButton[8][8];	//ボタンの配列を５個作成する[0]から[4]まで使える
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{ 
				int k;
				k = i*8 + j;
				buttonArray[i][j]= new JButton(Integer.toString(k));//ボタンに数値テキストを設定する
				c.add(buttonArray[i][j]);//ペインに貼り付ける
				buttonArray[i][j].setBounds(i*45+10,j*45+10,50,50);//ボタンの大きさと位置を設定する．(x座標，y座標,xの幅,yの幅）
			}
		}
		
	}
		
	public static void main(String[] args) 
	{
		GuiTest gui = new GuiTest();
		gui.setVisible(true);
	}
}