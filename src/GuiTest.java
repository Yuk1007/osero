import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class GuiTest extends JFrame 
{
	private JButton[][] buttonArray;	//�{�^���p�̔z��
	private Container c;

	public GuiTest() 
	{
		//�E�B���h�E���쐬����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�E�B���h�E�����Ƃ��ɁC����������悤�ɐݒ肷��
		this.setTitle("Gui Test");		//�E�B���h�E�̃^�C�g����ݒ肷��
		this.setSize(450,450);		//�E�B���h�E�̃T�C�Y��ݒ肷��
		c = this.getContentPane();	//�t���[���̃y�C�����擾����
		c.setLayout(null);		//�������C�A�E�g�̐ݒ���s��Ȃ�

		//�{�^���̐���
		buttonArray = new JButton[8][8];	//�{�^���̔z����T�쐬����[0]����[4]�܂Ŏg����
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{ 
				int k;
				k = i*8 + j;
				buttonArray[i][j]= new JButton(Integer.toString(k));//�{�^���ɐ��l�e�L�X�g��ݒ肷��
				c.add(buttonArray[i][j]);//�y�C���ɓ\��t����
				buttonArray[i][j].setBounds(i*45+10,j*45+10,50,50);//�{�^���̑傫���ƈʒu��ݒ肷��D(x���W�Cy���W,x�̕�,y�̕��j
			}
		}
		
	}
		
	public static void main(String[] args) 
	{
		GuiTest gui = new GuiTest();
		gui.setVisible(true);
	}
}