interface Y{
	void m1();
}

class C {
	public C(Y obj){
		obj.m1();
	}	
}

class D {
	public static void main(String[] args) {
		C annonyObj=new C(new Y(){
			public void m1(){
				System.out.println("i am running...");
			}
		});
	}
}