package gbkr.Animal;

public class Cat extends Animal {
    public Cat(String name, String birthDate) {
        super(name, birthDate);
    }

    @Override
    public String getType() {
        return "Cat";
    }
}
