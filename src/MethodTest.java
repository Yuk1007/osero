public class MethodTest{
	
	public static void main(String[] args) {
		System.out.println("x" + "\t" + "x^2" + "\t" + "x^3");
		for(double i = 0;i < 10.5;i += 0.5){
			System.out.print(i);
			System.out.print("\t");
			System.out.print(square(i));
			System.out.print("\t");
			System.out.println(cube(i));
		}
	}
	
	//二乗を行う関数（double版）
	public static double square(double num){
		return num*num;
	}

	public static double cube (double num){
		return num*num*num;
	}
}