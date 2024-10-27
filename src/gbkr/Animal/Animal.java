package gbkr.Animal;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    private String name;
    private List<String> commands;
    private String birthDate;

    public Animal(String name, String birthDate) {
        this.name = name;
        this.commands = new ArrayList<>();
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void learnCommand(String command) {
        commands.add(command);
    }

    public String getBirthDate() {
        return birthDate;
    }

    public abstract String getType();
}

