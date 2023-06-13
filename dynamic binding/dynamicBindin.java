class Animal {
    public void makeSound() {
        System.out.println("Animal is making a sound");
    }
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("Dog is barking");
    }
}

class Cat extends Animal {
    public void makeSound() {
        System.out.println("Cat is meowing");
    }
}

 class Main {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();
        animal1.makeSound(); // Dynamic binding occurs here
        animal2.makeSound(); // Dynamic binding occurs here
    }
}
