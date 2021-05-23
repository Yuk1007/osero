import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GuiEventTest extends JFrame implements MouseListener,MouseMotionListener {
	private JButton buttonArray[];//�{�^���p�̔z��
	private Container c;

	public GuiEventTest() {
		//�E�B���h�E���쐬����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�E�B���h�E�����Ƃ��ɁC����������悤�ɐݒ肷��
		setTitle("EventTest");		//�E�B���h�E�̃^�C�g����ݒ肷��
		setSize(400,400);		//�E�B���h�E�̃T�C�Y��ݒ肷��
		c = getContentPane();	//�t���[���̃y�C�����擾����
		c.setLayout(null);		//�������C�A�E�g�̐ݒ���s��Ȃ�

		//�{�^���̐���
		buttonArray = new JButton[5];//�{�^���̔z����T�쐬����[0]����[4]�܂Ŏg����
		for(int i=0;i<5;i++){
			buttonArray[i] = new JButton(Integer.toString(i));//�{�^���ɃA�C�R����ݒ肷��
			c.add(buttonArray[i]);//�y�C���ɓ\��t����
			buttonArray[i].setBounds(i*50,10,50,50);//�{�^���̑傫���ƈʒu��ݒ肷��D(x���W�Cy���W,x�̕�,y�̕��j
			buttonArray[i].addMouseListener(this);//�{�^�����}�E�X�ł�������Ƃ��ɔ�������悤�ɂ���
			buttonArray[i].addMouseMotionListener(this);//�{�^�����}�E�X�œ��������Ƃ����Ƃ��ɔ�������悤�ɂ���
			buttonArray[i].setActionCommand(Integer.toString(i));//�{�^���ɔz��̏���t������i�l�b�g���[�N����ăI�u�W�F�N�g�����ʂ��邽�߁j
		}
		
	}
		
	public static void main(String[] args) {
		GuiEventTest gui = new GuiEventTest();
		gui.setVisible(true);
	}
  	
	public void mouseClicked(MouseEvent e) {//�{�^�����N���b�N�����Ƃ��̏���
		System.out.println("�N���b�N");
		JButton theButton = (JButton)e.getComponent();//�N���b�N�����I�u�W�F�N�g�𓾂�D�^���Ⴄ�̂ŃL���X�g����
		String theArrayIndex = theButton.getActionCommand();//�{�^���̔z��̔ԍ������o��
		String ast = theButton.getText();
		String headast = ast.substring(0,1);
		if(headast.equals("*"))
		{
			theButton.setText(theArrayIndex);
		}
		else
		{
			theButton.setText("*"+theArrayIndex);	// �N���b�N�����ƃ{�^��������̐擪��'*'��t����
		}
	}

	
	public void mouseEntered(MouseEvent e) {//�}�E�X���I�u�W�F�N�g�ɓ������Ƃ��̏���
		System.out.println("�}�E�X��������");
	}
	
	public void mouseExited(MouseEvent e) {//�}�E�X���I�u�W�F�N�g����o���Ƃ��̏���
		System.out.println("�}�E�X�E�o");
	}
	
	public void mousePressed(MouseEvent e) {//�}�E�X�ŃI�u�W�F�N�g���������Ƃ��̏����i�N���b�N�Ƃ̈Ⴂ�ɒ��Ӂj
		System.out.println("�}�E�X��������");
	}
	
	public void mouseReleased(MouseEvent e) {//�}�E�X�ŉ����Ă����I�u�W�F�N�g�𗣂����Ƃ��̏���
		System.out.println("�}�E�X�������");
	}
	
	public void mouseDragged(MouseEvent e) {//�}�E�X�ŃI�u�W�F�N�g�Ƃ��h���b�O���Ă���Ƃ��̏���
		System.out.println("�}�E�X���h���b�O");
		JButton theButton = (JButton)e.getComponent();//�^���Ⴄ�̂ŃL���X�g����
		String theArrayIndex = theButton.getActionCommand();//�{�^���̔z��̔ԍ������o��

		Point theMLoc = e.getPoint();//�������R���|�[�l���g����Ƃ��鑊�΍��W
		System.out.println(theMLoc);//�f�o�b�O�i�m�F�p�j�ɁC�擾�����}�E�X�̈ʒu���R���\�[���ɏo�͂���
		Point theBtnLocation = theButton.getLocation();//�N���b�N�����{�^�������W���擾����
		theBtnLocation.x += theMLoc.x-15;//�{�^���̐^�񒆓�����Ƀ}�E�X�J�[�\��������悤�ɕ␳����
		theBtnLocation.y += theMLoc.y-15;//�{�^���̐^�񒆓�����Ƀ}�E�X�J�[�\��������悤�ɕ␳����
		theButton.setLocation(theBtnLocation);//�}�E�X�̈ʒu�ɂ��킹�ăI�u�W�F�N�g���ړ�����
 
		repaint();//�I�u�W�F�N�g�̍ĕ`����s��
	}

	public void mouseMoved(MouseEvent e) {//�}�E�X���I�u�W�F�N�g��ňړ������Ƃ��̏���
		System.out.println("�}�E�X�ړ�");
		int theMLocX = e.getX();//�}�E�X��x���W�𓾂�
		int theMLocY = e.getY();//�}�E�X��y���W�𓾂�
		System.out.println(theMLocX+","+theMLocY);//�R���\�[���ɏo�͂���
	}
}
