/*mabe7752 Marcus Bergengren*/

import java.util.ArrayList;

public class AssignmentSevenPointFive {

    private ArrayList<Dog> dogList = new ArrayList<>();

    private TextInput input = new TextInput();

    public void removeDog() {

        String name = input.readDogText("Enter the name of the dog");
        if (findDog(name) != null && name.toLowerCase().equals(findDog(name).getName().toLowerCase())) {
            dogList.remove(findDog(name));
        } else {
            System.out.println("Error: no such dog");
        }

    }

    public Dog findDog(String name) {
        for (Dog dog : dogList) {
            if (dog.getName().toLowerCase().trim().equals(name.trim().toLowerCase())) {
                return dog;
            }
        }
        return null;
    }
}
