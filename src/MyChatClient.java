import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyChatClient extends JFrame implements ActionListener{
	//�`���b�g��ʊ֘A
	JTextField tfKeyin;//���b�Z�[�W���͗p�e�L�X�g�t�B�[���h
	JTextArea taMain;//�e�L�X�g�G���A
	String myName;//���O��ۑ�
	JButton bs=new JButton("Send");
	private Container c;
	PrintWriter out;//�o�͗p�̃��C�^�[

	public MyChatClient(){
		//���O�̓��̓_�C�A���O���J��
		String myName = JOptionPane.showInputDialog(null,"���O����͂��Ă�������","���O�̓���",JOptionPane.QUESTION_MESSAGE);
		if(myName == null){
			myName = "No name";
		}
		
		//�E�B���h�E���쐬����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MyChatClient");
		setSize(600,400);
		c = getContentPane();
		c.setLayout(new FlowLayout());//���C�A�E�g�̐ݒ�

		//�`���b�g��ʂ��쐬����
		tfKeyin = new JTextField("",10);//���͗p�̃e�L�X�g�t�B�[���h���쐬
		c.add(tfKeyin);//�R���e�i�ɒǉ�
		c.add(bs);//�{�^�����R���e�i�ɒǉ�
		tfKeyin.setBounds(70,200,100,25);
		bs.addActionListener(this);//�{�^�����������Ƃ��̓��삷��悤�ɂ���
		taMain = new JTextArea(20,50);//�`���b�g�̏o�͗p�̃t�B�[���h���쐬
		c.add(taMain);//�R���e�i�ɒǉ�
		taMain.setBounds(80,200,200,25);
		taMain.setEditable(false);//�ҏW�s�ɂ���

		//�T�[�o�ɐڑ�����
		Socket socket = null;
		try {
			//"localhost"�́C���������ւ̐ڑ��Dlocalhost��ڑ����IP Address�i"133.42.155.201"�`���j�ɐݒ肷��Ƒ���PC�̃T�[�o�ƒʐM�ł���
			//10000�̓|�[�g�ԍ��DIP Address�Őڑ�����PC�����߂āC�|�[�g�ԍ��ł���PC�㓮�삷��v���O��������肷��
			socket = new Socket("localhost", 10000);
		} catch (UnknownHostException e) {
			System.err.println("�z�X�g�� IP �A�h���X������ł��܂���: " + e);
		} catch (IOException e) {
			 System.err.println("�G���[���������܂���: " + e);
		}
		
		MesgRecvThread mrt = new MesgRecvThread(socket, myName);
		mrt.start();
	}

	//���b�Z�[�W��M�̂��߂̃X���b�h
	public class MesgRecvThread extends Thread {
		
		Socket socket;
		String myName;
		
		public MesgRecvThread(Socket s, String n){
			socket = s;
			myName = n;
		}
		
		//�ʐM�󋵂��Ď����C��M�f�[�^�ɂ���ē��삷��
		public void run() {
			try{
				InputStreamReader sisr = new InputStreamReader(socket.getInputStream());
				BufferedReader br = new BufferedReader(sisr);
				out = new PrintWriter(socket.getOutputStream(), true);
				out.println(myName);//�ڑ��̍ŏ��ɖ��O�𑗂�
				while(true) {
					String inputLine = br.readLine();
					if (inputLine != null) {
						taMain.append(inputLine+"\n");//���b�Z�[�W�̓��e���o�͗p�e�L�X�g�ɒǉ�����
					}
					else{
						break;
					}
				}
				socket.close();
			} catch (IOException e) {
				System.err.println("�G���[���������܂���: " + e);
			}
		}
	}
	
	//�A�N�V�������s��ꂽ�Ƃ��̏���
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand()=="Send") {
			String msg = tfKeyin.getText();//���͂����e�L�X�g�𓾂�
			tfKeyin.setText("");//tfKeyin��Text���N���A����
			if(msg.length()>0){//���͂������b�Z�[�W�̒������O�Ŗ�����΁C
				out.println(msg);
				out.flush();
			}
		}
  	}
  	
  	public static void main(String[] args) {
		MyChatClient cc = new MyChatClient();
		cc.setVisible(true);
	}
}
