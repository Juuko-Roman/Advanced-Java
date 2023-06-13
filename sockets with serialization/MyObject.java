import java.io.Serializable;

public class MyObject implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    
    public MyObject(String name) {
        this.name = name;
    }
    
    public String greet() {
        return "Hello, my name is " + name;
    }
}
