package dsa.javaCourse;

public class ReferenceLearn {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        animal.speak();
        dog.speak();
        Animal animal1 = new Dog();
        animal1.speak();
       /* Dog dog1 = (Dog) new Animal();
        dog1.speak();
        java.lang.ClassCastException: class dsa.javaCourse.Animal cannot be cast to class dsa.javaCourse.Dog (dsa.javaCourse.Animal and dsa.javaCourse.Dog are in unnamed module of loader 'app')
	at dsa.javaCourse.LambdaLearn.main(LambdaLearn.java:18)*/
    }
}
