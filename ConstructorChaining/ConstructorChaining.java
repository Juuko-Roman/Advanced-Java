class ConstructorChaining{
    // default constructor 1
    ConstructorChaining()
    {
        System.out.println("default");
    }
 
    // parameterized constructor 2
    ConstructorChaining(int x)
    {
        // invokes default constructor
        this();
        System.out.println(x);
    }
 
    // parameterized constructor 3
    ConstructorChaining(int x, int y)
    {
        // invokes parameterized constructor 2
        this(5);
        System.out.println(x * y);
    }
	public static void main(String args[])
    {
        // invokes parameterized constructor 3
        new ConstructorChaining(8, 10);

		//output 
		// default
		// 5
		// 80
    }
}