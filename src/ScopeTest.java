public class ScopeTest{

	static int a;

	public static void main(String[] args) {
		a=5;
		System.out.println("���������� a="+a);
		scope1();

		System.out.println("scope1()���Ă񂾌� a="+a);
		scope2();
		System.out.println("scope2()���Ă񂾌� a="+a);

		for(int i=0;i<3;i++){
			int a = 0;
			a = a + i;
			System.out.println("for���̒� a="+a);
		}
		System.out.println("for���𔲂����� a="+a);
	}
	
	public static void scope1(){
		a=10;
		System.out.println("scope1�̒� a="+a);
	}
	
	public static void scope2(){
		int a=20;
		System.out.println("scope2�̒� a="+a);
	}

}
