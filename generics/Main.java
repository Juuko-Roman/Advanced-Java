 //generic class
class Box<T> {
    private T content;

    public void add(T item) {
        this.content = item;
    }

    public T get() {
        return this.content;
    }
}

class Main{
    //generic method
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<Integer>();
        intBox.add(42);
        int myInt = intBox.get();
        System.out.println("int box is "+myInt);

        Box<String> strBox = new Box<String>();
        strBox.add("Hello, world!");
        String myStr = strBox.get();
        System.out.println("int strBox is "+myStr);

        String[] names = {"Alice", "Bob", "Charlie"};
        printArray(names);

        Integer[] numbers = {1, 2, 3};
        printArray(numbers);
    }
}