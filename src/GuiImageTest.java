import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GuiImageTest extends JFrame implements MouseListener,MouseMotionListener {
	private JButton buttonArray[];//�{�^���p�̔z��
	private Container c;
	private ImageIcon blackIcon, whiteIcon, boardIcon;

	public GuiImageTest() {
		//�E�B���h�E���쐬����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�E�B���h�E�����Ƃ��ɁC����������悤�ɐݒ肷��
		setTitle("EventTest");		//�E�B���h�E�̃^�C�g����ݒ肷��
		setSize(400,400);		//�E�B���h�E�̃T�C�Y��ݒ肷��
		c = getContentPane();	//�t���[���̃y�C�����擾����
		c.setLayout(null);		//�������C�A�E�g�̐ݒ���s��Ȃ�

		//�A�C�R���̐ݒ�
		whiteIcon = new ImageIcon("White.jpg");
		blackIcon = new ImageIcon("Black.jpg");
		boardIcon = new ImageIcon("GreenFrame.jpg");

		//�{�^���̐���
		buttonArray = new JButton[5];//�{�^���̔z����T�쐬����[0]����[4]�܂Ŏg����
		for(int i=0;i<5;i++){
			buttonArray[i] = new JButton(boardIcon);//�{�^���ɃA�C�R����ݒ肷��
			c.add(buttonArray[i]);//�y�C���ɓ\��t����
			buttonArray[i].setBounds(i*45,10,45,45);//�{�^���̑傫���ƈʒu��ݒ肷��D(x���W�Cy���W,x�̕�,y�̕��j
			buttonArray[i].addMouseListener(this);//�{�^�����}�E�X�ł�������Ƃ��ɔ�������悤�ɂ���
			buttonArray[i].addMouseMotionListener(this);//�{�^�����}�E�X�œ��������Ƃ����Ƃ��ɔ�������悤�ɂ���
			buttonArray[i].setActionCommand(Integer.toString(i));//�{�^���ɔz��̏���t������i�l�b�g���[�N����ăI�u�W�F�N�g�����ʂ��邽�߁j
		}
		
	}
		
	public static void main(String[] args) {
		GuiImageTest gui = new GuiImageTest();
		gui.setVisible(true);
	}
  	
	public void mouseClicked(MouseEvent e) {//�{�^�����N���b�N�����Ƃ��̏���
		System.out.println("�N���b�N");
		JButton theButton = (JButton)e.getComponent();//�N���b�N�����I�u�W�F�N�g�𓾂�D�^���Ⴄ�̂ŃL���X�g����
		String theArrayIndex = theButton.getActionCommand();//�{�^���̔z��̔ԍ������o��

		Icon theIcon = theButton.getIcon();//theIcon�ɂ́C���݂̃{�^���ɐݒ肳�ꂽ�A�C�R��������
		System.out.println(theIcon);//�f�o�b�O�i�m�F�p�j�ɁC�N���b�N�����A�C�R���̖��O���o�͂���

		if(theIcon.equals(boardIcon)){//�A�C�R����boardIcon�Ɠ����Ȃ�
			theButton.setIcon(whiteIcon);//whiteIcon�ɐݒ肷��
		}else if(theIcon.equals(whiteIcon)){
			theButton.setIcon(blackIcon);//blackIcon�ɐݒ肷��
		}else{
			theButton.setIcon(boardIcon);
		}
		repaint();//��ʂ̃I�u�W�F�N�g��`�悵����
	}
	
	public void mouseEntered(MouseEvent e) {//�}�E�X���I�u�W�F�N�g�ɓ������Ƃ��̏���
	}
	
	public void mouseExited(MouseEvent e) {//�}�E�X���I�u�W�F�N�g����o���Ƃ��̏���
	}
	
	public void mousePressed(MouseEvent e) {//�}�E�X�ŃI�u�W�F�N�g���������Ƃ��̏����i�N���b�N�Ƃ̈Ⴂ�ɒ��Ӂj
	}
	
	public void mouseReleased(MouseEvent e) {//�}�E�X�ŉ����Ă����I�u�W�F�N�g�𗣂����Ƃ��̏���
	}
	
	public void mouseDragged(MouseEvent e) {//�}�E�X�ŃI�u�W�F�N�g�Ƃ��h���b�O���Ă���Ƃ��̏���
	}

	public void mouseMoved(MouseEvent e) {//�}�E�X���I�u�W�F�N�g��ňړ������Ƃ��̏���
	}
}
