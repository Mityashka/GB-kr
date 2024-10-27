package gbkr.Animal;

public class Hamster extends Animal {
    public Hamster(String name, String birthDate) {
        super(name, birthDate);
    }

    @Override
    public String getType() {
        return "Hamster";
    }
}