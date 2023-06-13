public class Outer {
    private int outerField;

    public void createInnerClasses() {
        for (int i = 1; i <= 5; i++) {
            final int loopVariable = i;  // Final variable for inner class access

            // Inner class defined inside the for loop
            class Inner {
                public void display() {
                    System.out.println("Loop variable: " + loopVariable);
                    System.out.println("Outer field: " + outerField++);
                }
            }

            // Creating an instance of the inner class and invoking display()
            Inner innerObject = new Inner();
            innerObject.display();
        }
    }

    public static void main(String[] args) {
        Outer outerObject = new Outer();
        outerObject.outerField=5;
        outerObject.createInnerClasses();
    }
}
