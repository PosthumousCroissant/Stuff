/*mabe7752 Marcus Bergengren*/

import java.util.ArrayList;

public class AssignmentEightPointEight {

    private ArrayList<Dog> dogList = new ArrayList<>();

    private ArrayList<Owner> listOfOwners = new ArrayList<>();

    private TextInput input = new TextInput();

    public void removeDog() {
        String name;
        do {
            name = input.readDogText("Enter the name of the dog");
            if (name == null || name.trim().isEmpty()) {
                System.out.println("Error: name cannot be empty");
            }
        }
        while (name == null || name.trim().isEmpty());

        if (findDog(name) != null && name.trim().equalsIgnoreCase(findDog(name).getName())) {
            if (findDog(name).getOwner() != null) {
                findDog(name).getOwner().removeDogThatBelongsToOwner(findDog(name));
            }
            dogList.remove(findDog(name));
        } else {
            System.out.println("Error: no such dog");
        }
    }

    public Dog findDog(String name) {
        for (Dog dog : dogList) {
            if (dog.getName().trim().equalsIgnoreCase(name.trim())) {
                return dog;
            }
        }
        return null;
    }

    public void giveDog() {
        Dog dog = askForDogName();
        if (dog == null) {
            return;
        }
        Owner owner = askForOwnerName();

        if (dog != null && owner != null) {
            dog.setOwner(owner);
            System.out.println(owner.getName() + " now owns " + dog.getName());
        }
    }

    private Dog checkDog(String name) {
        for (Dog dog : dogList) {
            if (dog.getOwner() == null && dog.getName().equalsIgnoreCase(name.trim())) {
                return dog;
            } else if (dog.getName().equalsIgnoreCase(name.trim())) {
                System.out.println("Error: dog already has an owner");
                return null;
            }
        }

        System.out.println("Error: no such dog");
        return null;
    }

    private Owner checkOwner(String name) {
        for (Owner o : listOfOwners) {
            if (o.getName().equalsIgnoreCase(name.trim())) {
                return o;
            }
        }

        System.out.println("Error: no such owner");
        return null;
    }

    private Dog askForDogName() {
        Dog dog;
        String name;
        do {
            name = input.readDogText("Enter the name of the dog");
            if (name.trim().isEmpty()) {
                System.out.println("Error: name can't be empty");
            }
        } while (name.trim().isEmpty());
        if ((dog = checkDog(name)) != null) {
            return dog;
        }
        return null;
    }

    private Owner askForOwnerName() {
        Owner owner;
        String name;
        do {
            name = input.readDogText("Enter the name of the new owner");
            if (name.trim().isEmpty()) {
                System.out.println("Error: name can't be empty");
            }
        } while (name.trim().isEmpty());
        if ((owner = checkOwner(name)) != null) {
            return owner;
        }
        return null;
    }
}
