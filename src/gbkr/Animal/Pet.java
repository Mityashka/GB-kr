package gbkr.Animal;

public class Pet extends Animal {
    public Pet(String name, String birthDate) {
        super(name, birthDate);
    }
    @Override
    public String getType() {
        return "Pet"; // можно задать тип как "Pet"
    }
}
