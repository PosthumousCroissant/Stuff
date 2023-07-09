/*mabe7752 Marcus Bergengren*/

import java.util.ArrayList;

public class AssignmentEightPointFour {

    private ArrayList<Dog> dogList = new ArrayList<>();

    private ArrayList<Owner> listOfOwners = new ArrayList<>();

    private TextInput input = new TextInput();

    public void listOwners() {
        for (Owner o : listOfOwners) {
            System.out.println(o.getName() + dogsBelongingToOwner(o));
        }
        if (listOfOwners.isEmpty()) {
            System.out.println("Error: no owners");
        }
    }

    private ArrayList dogsBelongingToOwner(Owner owner) {
        ArrayList<Dog> dogsBelongingToOwner = new ArrayList<>();
        for (Dog dog : dogList) {
            if (dog.getOwner() == owner) {
                dogsBelongingToOwner.add(dog);
            }
        }
        return dogsBelongingToOwner;
    }

    public void listDogs() {
        if (!(dogList.isEmpty())) {
            double tailLength = input.readDogDouble("Smallest tail length to display");
            dogListTailLength(tailLength);
        } else {
            System.out.println("Error: no dogs in register");
        }

    }

    private void dogListTailLength(double tailLength) {
        int counter = 0;
        for (Dog dog : dogList) {
            if (dog.getTailLength() >= tailLength) {
                if (checkIfDogHasOwner(dog) != null) {
                    System.out.println(dog + dog.getOwner().getName());
                } else {
                    System.out.println(dog);
                }
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("Error: no dog have a tail that long");
        }
    }

    private Owner checkIfDogHasOwner(Dog dog) {
        if (dog.getOwner() != null) {
            return dog.getOwner();
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
            owner.addDogToOwner(dog);
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
