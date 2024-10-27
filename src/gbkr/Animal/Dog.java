package gbkr.Animal;

public class Dog extends Animal {
    public Dog(String name, String birthDate) {
        super(name, birthDate);
    }

    @Override
    public String getType() {
        return "Dog";
    }
}