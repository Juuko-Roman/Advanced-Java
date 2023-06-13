
public class B  {
	public static void main(String[] args) {
		A.X objX=new A.X();  //static inner class X
		A.Y objY=new A().new Y(); // non static class Y
	}
}