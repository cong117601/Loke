package aaa;

public class IntegerTest {
	public static void main(String[] args) {

		Integer a1 = 300;
		Integer a2 = 300;
		System.out.println(a1.valueOf(300).intValue() == a2);
		System.out.println(a1.equals(a2));

		System.out.println("修改它");
	}
}
