class C {
	public void run(){
		System.out.println("i am running...");
	} 
}

class D {
	
	public static void main(String[] args) {
		
		C annonyObj=new C(){
			public void run(){
				System.out.println("overriden: i am running...1111");
			}
		};
		annonyObj.run();
	}
}