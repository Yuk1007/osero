public class StringTest {
    public static void main(String[] args) {

		// ������̐錾�C�錾�ƂƂ��ɒl��ݒ�
		String a = "Good ";
		String b = "Morning!";


		// System.out.println�̓R�}���h�v�����v�g�i�R���\�[���j�ւ̏o��
		System.out.println("a=" + a);
		System.out.println("b=" + b);


		// �������+�ŕ����񓯎m��A������
		String c = a+b;
		System.out.println("c=" + c);

		
		// equals()�ŕ�����̔�r���s��
		if (a.equals("good ")) {
			System.out.println("�ϐ�a �̒l�� good �ł��D");
		} else {
			System.out.println("�ϐ�a �̒l�� good �ł͂���܂���D");
		}
		

		// equalsIgnoreCase()�ő啶���C�������𖳎�����������̔�r���s��
		if (a.equalsIgnoreCase("good ")) {
			System.out.println("�ϐ�a �̒l�� good �ł��D");
		} else {
			System.out.println("�ϐ�a �̒l�� good �ł͂���܂���D");
		}


		// toLowerCase()�őS�ď�������
		System.out.println(c.toLowerCase());
		
		// toUpperCase()�őS�đ啶����
		System.out.println(c.toUpperCase());


		// length()�ŁC������̒����𓾂�
		int alen = a.length();
		int blen = b.length();
		System.out.println("������ a �̒����� " + alen );
		System.out.println("������ b �̒����� " + blen );
		System.out.println("������ c �̒����� " + c.length());

		
		// substring(�J�n�ʒu�C�I���ʒu)�ŁC��������������o���܂��D
		// �I���ʒu���w�肵�Ȃ��ƁC�J�n�ʒu���疖���܂Ŏ��o���܂��D
		String e = c.substring(2,4);
		System.out.println(e);
		String f = c.substring(5);
 		System.out.println(f);


		// �����ۑ�
		System.out.println ("�m�F�P�F"+ (a == "Good ") );

		String foo= "the Good Event";
		String subfoo = foo.substring(4,9);
		System.out.println ("|"+ subfoo +"|");
		System.out.println ("�m�F�Q(==�̏ꍇ)�F"+ (a == subfoo) );
		System.out.println ("�m�F�Q(equals�̏ꍇ)�F"+ (a.equals(subfoo)) );
		
	}
}