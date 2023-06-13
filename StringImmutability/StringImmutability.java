public class StringImmutability {
	public static void main(String[] args) {
		String str1 = "hello";
		String str2 = str1.toUpperCase(); // new instance

		System.out.println(str1); // Output: hello
		System.out.println(str2); // Output: HELLO
	}
}