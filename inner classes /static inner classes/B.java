class A {
	static class X{
		int x; int y;
		public X(int x, int y){
			this.x=x;
			this.y=y;
		}
		@Override 
		public String toString(){
			return ("x: " + x + "\n"
					+ "y: " + y + "\n");
		}
	}
	
	class Y{
		int p; int q;
		public Y(int p, int q){
			this.p=p;
			this.q=q;
		}
		@Override 
		public String toString(){
			return ("p: " + p + "\n"
					+ "q: " + q + "\n");
		}
	}
}
class B  {
	public static void main(String[] args) {
		A.X objX=new A.X(4,5);  //static inner class X
		A.Y objY=new A().new Y(6,7); // non static class Y

		System.out.print("objX is "+objX.toString());
		System.out.print("objY is "+objY.toString());
	}
}