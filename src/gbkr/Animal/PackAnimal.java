package gbkr.Animal;

public class PackAnimal extends Animal {
    public PackAnimal(String name, String birthDate) {
        super(name, birthDate);
    }

    @Override
    public String getType() {
        return "Pack Animal";
    }
}
