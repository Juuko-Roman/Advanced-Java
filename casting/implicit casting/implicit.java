class A{
	int a;
	public void m(A obj){//implicit casting occurs here where the passed subclass object is casted to supertype reference
		System.out.println(obj.a);
	}
}

class B extends A{
	public static void main(String[] args) {
		B myObj =new B();
		myObj.a=3;
		myObj.m(myObj);
	}
}