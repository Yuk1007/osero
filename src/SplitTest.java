public class SplitTest {
    public static void main(String[] args) {

		String text = "GET 5 5 1";

		// Split���g���Ė��߂𕪊�����
		String[] data = text.split(" ");

		// ���������X�̗v�f���P�s���\������D
		// data�z��̗v�f����.length�ŕ\�����
		for (int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}

   }
}