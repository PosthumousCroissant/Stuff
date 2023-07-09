/*mabe7752 Marcus Bergengren*/

import java.util.ArrayList;

public class AssignmentSevenPointTwo {

    private TextInput input = new TextInput();

    private ArrayList<Dog> dogList = new ArrayList<>();

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

}