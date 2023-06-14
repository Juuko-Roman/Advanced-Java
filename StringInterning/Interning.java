class Interning{
	public static void main(String[] args) {
		String str1 = "hello";
		String str2 = "hello";
		String str3 = new String("hello").intern(); // same reference as above
		String str4 = new String("hello");

		System.out.println(str1 == str2); // Output: true
		System.out.println(str1 == str3); // Output: true
		System.out.println(str1 == str4); // Output: false
	}
}