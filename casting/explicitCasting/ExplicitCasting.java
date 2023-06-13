class Vehicle {
    public void drive() {
        System.out.println("Driving a vehicle");
    }
}

class Car extends Vehicle {
    public void drive() {
        System.out.println("Driving a car");
    }
    
    public void drift() {
        System.out.println("Car drifting");
    }
}

public class ExplicitCasting {
    public static void main(String[] args) {
        Vehicle vehicle = new Car();  // Implicit upcasting from Car to Vehicle
        vehicle.drive();  // Output: Driving a car

        // vehicle.drift();  this line would throw an error
        
        if (vehicle instanceof Car) {
            Car car = (Car) vehicle;  // Explicit downcasting from Vehicle to Car
            car.drift();  // Output: Car drifting
        }
    }
}
