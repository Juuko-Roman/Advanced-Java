interface C {
	void run();
}

class D  {
	public static void main(String[] args) {

		C annonyObj=new C(){
			public void run(){
				System.out.println("run implemented: i am running in annonymous...");
			}
		}
		
		annonyObj.run();
	}
}