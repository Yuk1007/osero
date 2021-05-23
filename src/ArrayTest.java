class ArrayTest {
	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		int[] b;
		a[0] = 5;

		b = a;

		System.out.println(b[0]);
		System.out.println(b[1]);
		System.out.println(b[2]);
	}
}
