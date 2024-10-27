package gbkr.Programs;

import gbkr.Animal.Animal;
import gbkr.Animal.Dog;
import gbkr.Animal.Cat;
import gbkr.Animal.Hamster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalRegistry {
    private List<Animal> animals;

    public AnimalRegistry() {
        animals = new ArrayList<>();
    }

    // Завести новое животное
    public void addAnimal(String name, String type, String birthDate) {
        Animal animal;
        switch (type.toLowerCase()) {
            case "dog":
                animal = new Dog(name, birthDate); // передаем дату рождения
                break;
            case "cat":
                animal = new Cat(name, birthDate); // передаем дату рождения
                break;
            case "hamster":
                animal = new Hamster(name, birthDate); // передаем дату рождения
                break;
            default:
                System.out.println("Неизвестный тип животного.");
                return;
        }
        animals.add(animal);
        System.out.println("Животное добавлено: " + animal.getType() + " - " + name);
    }

    // Просмотр списка команд
    public void showCommands(String name) {
        Animal animal = findAnimalByName(name);
        if (animal != null) {
            System.out.println("Команды для " + name + ": " + animal.getCommands());
        } else {
            System.out.println("Животное с именем " + name + " не найдено.");
        }
    }

    // Обучение животного новым командам
    public void trainAnimal(String name, String command) {
        Animal animal = findAnimalByName(name);
        if (animal != null) {
            animal.learnCommand(command);
            System.out.println("Животное " + name + " обучено команде: " + command);
        } else {
            System.out.println("Животное с именем " + name + " не найдено.");
        }
    }

    private Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }

    // меню
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Завести новое животное");
            System.out.println("2. Показать команды животного");
            System.out.println("3. Обучить животное новой команде");
            System.out.println("4. Выйти");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите имя животного: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите тип животного (Dog, Cat, Hamster): ");
                    String type = scanner.nextLine();
                    System.out.print("Введите дату рождения животного: ");
                    String birthDate = scanner.nextLine(); // Запрашиваем дату рождения
                    addAnimal(name, type, birthDate); // Передаем имя, тип и дату рождения
                    break;
                case 2:
                    System.out.print("Введите имя животного: ");
                    String animalName = scanner.nextLine();
                    showCommands(animalName);
                    break;
                case 3:
                    System.out.print("Введите имя животного: ");
                    String animalToTrain = scanner.nextLine();
                    System.out.print("Введите команду: ");
                    String command = scanner.nextLine();
                    trainAnimal(animalToTrain, command);
                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }
}
